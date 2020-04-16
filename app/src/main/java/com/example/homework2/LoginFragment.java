package com.example.homework2;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    private Button b1;
    private EditText ed1,ed2;

    private TextView tx1;
    private int counter = 3;
    private String email_str, password_str;
    private SharedPreferences preferences;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_login, container, false);

        b1 = (Button) view.findViewById(R.id.btn_login);

        tx1 = (TextView) view.findViewById(R.id.counter_text);

        preferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1 = (EditText) view.findViewById(R.id.et_email_login);
                ed2 = (EditText) view.findViewById(R.id.et_password_login);

                email_str = ed1.getText().toString();
                password_str = ed2.getText().toString();

                if(password_str.equals(preferences.getString(email_str, null))) {
                    Toast.makeText(getActivity().getApplicationContext(),
                            "User successfully logged in",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity().getApplicationContext(), MenuActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getActivity().getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();

                    tx1.setVisibility(View.VISIBLE);
                    counter--;
                    tx1.setText(Integer.toString(counter));

                    if (counter == 0) {
                        b1.setEnabled(false);
                        getActivity().finish();
                    }
                }
            }
        });

        return view;
    }

}
