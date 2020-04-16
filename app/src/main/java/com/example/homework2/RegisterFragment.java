package com.example.homework2;


import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
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
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
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

        final String name_str = name_et.getText().toString();
        final String email_str = email_et.getText().toString();
        final String password_str = password_et.getText().toString();
        final String repassword_str = repassword_et.getText().toString();

        register_btn = (Button) view.findViewById(R.id.btn_register);
        register_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!password_str.equals(repassword_str)) {
                    Toast.makeText(getActivity().getApplicationContext(), "Passwords does not match",Toast.LENGTH_SHORT).show();
                    name_et.setText("");
                    email_et.setText("");
                    password_et.setText("");
                    repassword_et.setText("");
                } else if(name_str.equals("") || email_str.equals("") || password_str.equals("")) {
                    Toast.makeText(getActivity().getApplicationContext(), "Fields cannot be empty",Toast.LENGTH_SHORT).show();
                    name_et.setText("");
                    email_et.setText("");
                    password_et.setText("");
                    repassword_et.setText("");
                } else {
                    preferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
                    editor = preferences.edit();
                    editor.putString(email_str, password_str);
                    editor.commit();
                }
            }
        });


        return view;
    }

}
