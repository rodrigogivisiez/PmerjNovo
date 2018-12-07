package br.gov.rj.arquivo.ui.login;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.Navigation;
import br.gov.rj.arquivo.R;
import br.gov.rj.arquivo.databinding.ResetFragmentBinding;
import br.gov.rj.arquivo.util.OpenFragmentNavigation;
import br.gov.rj.arquivo.util.SnackbarMessage;
import br.gov.rj.arquivo.util.SnackbarUtils;


public class ResetFragment extends Fragment {

    private SharedViewModel viewModel;
    public static ResetFragment newInstance() {
        return new ResetFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);

        ResetFragmentBinding binding = ResetFragmentBinding.inflate(inflater,
                container, false);

        binding.setShared(viewModel);
        binding.resetBotao.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewModel.resetSenhaTokenEmail();
                    }
                }
                // Navigation.findNavController(view).navigate(R.id.loginFragment);
                //    Navigation.findNavController(view).getNavigatorProvider().getNavig
                //findNavController(fragment).navigate(SignInFragmentDirections.actionSignInFragmentToUserNameFragment())
                // Navigation.createNavigateOnClickListener(R.id.loginFragment, null)
                //getActivity().getSupportFragmentManager().
        );
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupNavigation();
        setupSnackbar();
    }

    private void setupSnackbar() {
        viewModel.getSnackbarMessage().observe(this, new SnackbarMessage.SnackbarObserver() {
            @Override
            public void onNewMessage(@StringRes int snackbarMessageResourceId) {
                SnackbarUtils.showSnackbar(getView(), getString(snackbarMessageResourceId));
            }
        });
    }
    private void setupNavigation() {
        viewModel.getmNavigationDestino().observe(this, new OpenFragmentNavigation.DestinoObserver() {
            @Override
            public void onNewMessage(int snackbarMessageResourceId) {
                Log.e("givix","setup nagivigation in resetfragment");
                Navigation.findNavController(getActivity(), R.id.loginFragment);
            }
        });
    }

}
