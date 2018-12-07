package br.gov.rj.arquivo.ui.login;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.navigation.NavAction;
import androidx.navigation.Navigation;
import br.gov.rj.arquivo.R;
import br.gov.rj.arquivo.databinding.LoginFragmentBinding;
import br.gov.rj.arquivo.util.OpenFragmentNavigation;
import br.gov.rj.arquivo.util.SnackbarMessage;
import br.gov.rj.arquivo.util.SnackbarUtils;


public class LoginFragment extends Fragment {
    SharedViewModel viewModel;
    LoginFragmentBinding binding;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);

        binding = LoginFragmentBinding.inflate(inflater,
                container, false);

        binding.setShared(viewModel);

        binding.loginBotaoEsqueciSenha.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_redefinirFragment, null)
        );

        binding.loginButtonLogIn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        logar(v);
                    }
                }
        );


        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupSnackbar();
        setupNavigation();

    }

    @Override
    public void onStart() {
        super.onStart();
        if(getActivity().getIntent().getData() != null){
            String  first = getActivity().getIntent().getData().getLastPathSegment();
            String  last = getActivity().getIntent().getData().getLastPathSegment();
            Log.e("givix ","first - " + first + " last -> " + last);
            viewModel.getLogin().setCpf(last);
           // Navigation.findNavController(binding.getRoot()).navigate(R.id.action_loginFragment_to_resetFragment);
        }
    }

    public void logar(View v){
        if(validLogin()) {
            Log.e("givix", "botao clicado");
            if (!binding.loginPassword.getText().toString().equals("")) {
                viewModel.getLogin().setSenha(binding.loginPassword.getText().toString());
            }
            if (!binding.loginCpf.getText().toString().equals("")) {
                viewModel.getLogin().setCpf(binding.loginCpf.getText().toString());
            }
            viewModel.logar();
        }
    }

    public boolean validLogin(){
        boolean isValid = true;
        if(!validateNotNull(binding.loginPassword,"Preencha a senha!")) {
            isValid = false;
        }
        if(!validateNotNull(binding.loginCpf,"Preencha o cpf!")) {
            isValid = false;
        }
        return isValid;
    }

    public static boolean validateNotNull(View pView, String pMessage) {
        if (pView instanceof EditText) {
            EditText edText = (EditText) pView;
            Editable text = edText.getText();
            if (text != null) {
                String strText = text.toString();
                if (!TextUtils.isEmpty(strText)) {
                    return true;
                }
            }
            edText.setError(pMessage);
            edText.setFocusable(true);
            edText.requestFocus();
            return false;
        }
        return false;
    }

    private void setupSnackbar() {
        viewModel.getSnackbarMessage().observe(this, new SnackbarMessage.SnackbarObserver() {
            @Override
            public void onNewMessage(@StringRes int snackbarMessageResourceId) {
                Log.e("login Activity", "mensagem pelo observador equals to setup new fragement");
                SnackbarUtils.showSnackbar(getView(), getString(snackbarMessageResourceId));
            }
        });
    }

    private void setupNavigation() {
        Log.e("givix","entrou em  loginfragment");

        viewModel.getmNavigationDestino().observe(this, new OpenFragmentNavigation.DestinoObserver() {
            @Override
            public void onNewMessage(int snackbarMessageResourceId) {
                Log.e("givix","setup nagivigation in loginfragment");
                Navigation.findNavController(binding.getRoot()).navigate(R.id.action_loginFragment_to_devMenuFragment);
                //Navigation.findNavController(binding.getRoot(), R.id.action_loginFragment_to_devMenuFragment);
                //Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_devMenuFragment, null);
            }
        });
    }

}
