package br.gov.rj.arquivo.ui.login;

import android.arch.lifecycle.Observer;
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
import br.gov.rj.arquivo.databinding.RedefinirFragmentBinding;
import br.gov.rj.arquivo.util.SnackbarMessage;
import br.gov.rj.arquivo.util.SnackbarUtils;


public class RedefinirFragment extends Fragment {

    SharedViewModel viewModel;

    public static RedefinirFragment newInstance() {
        return new RedefinirFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);

        RedefinirFragmentBinding binding = RedefinirFragmentBinding.inflate(inflater,
                container, false);

        binding.setShared(viewModel);
        binding.redefinirBotaoJaPossuiCodigo.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_redefinirFragment_to_resetFragment, null)
        );

        binding.redefinirBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {viewModel.resetEmail();
            }});

        viewModel.getNavigateToNext().observe(this, new Observer() {
            @Override
            public void onChanged(@Nullable Object o) {
                Log.e("chamando navegacao " , " tentantdo navegar ------");
                //  Navigation.createNavigateOnClickListener(R.id.action_redefinirFragment_to_resetFragment, null);
                //Navigation.findNavController(binding.getRoot()).getCurrentDestination();

                Navigation.findNavController(binding.getRoot()).navigate(R.id.action_redefinirFragment_to_resetFragment);
                //Navigation.findNavController(binding.getRoot()).navig;
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupNavigation();
        setupSnackbar();
    }

    private void setupNavigation() {
        viewModel.getNavigateToNext().observe(this, new Observer() {
            @Override
            public void onChanged(@Nullable Object o) {
                Log.e("givix","setup nagivigation in redefinirFragment");
                Navigation.createNavigateOnClickListener(R.id.action_redefinirFragment_to_resetFragment, null);
            }
        });
    }

    private void setupSnackbar() {
        viewModel.getSnackbarMessage().observe(this, new SnackbarMessage.SnackbarObserver() {
            @Override
            public void onNewMessage(@StringRes int snackbarMessageResourceId) {
                SnackbarUtils.showSnackbar(getView(), getString(snackbarMessageResourceId));
            }
        });
    }
}
