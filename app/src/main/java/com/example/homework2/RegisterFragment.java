package com.example.homework2;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {
    private Button register_btn;
    private EditText name_et, email_et, password_et, repassword_et;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        name_et = (EditText) view.findViewById(R.id.et_name);
        email_et = (EditText) view.findViewById(R.id.et_email);
        password_et = (EditText) view.findViewById(R.id.et_password);
        repassword_et = (EditText) view.findViewById(R.id.et_repassword);

        register_btn = (Button) view.findViewById(R.id.btn_register);
        register_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                User user = new User("ibrahim gulec", "ibrahim@email.com", "12345678");
                if(password_et.getText() != repassword_et.getText()) {
                    Toast.makeText(getActivity().getApplicationContext(), "Passwords does not match",Toast.LENGTH_SHORT).show();
                } else {
                    System.out.println(name_et.getText());
                    System.out.println(email_et.getText());
                    System.out.println(password_et.getText());
                    System.out.println(repassword_et.getText());
                }
                System.out.println(user);
            }
        });


        return view;
    }

}
