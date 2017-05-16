package com.example.kiran.task;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by kiran on 5/15/2017.
 */

public class CustomeDialogFragment extends DialogFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.dialogfragment, container, false);
        TextView dialogText = (TextView) rootView.findViewById(R.id.dialog_text);
        TextView dialogButtonOk = (Button) rootView.findViewById(R.id.button_dialog_ok);

        setCancelable(false);
        dialogText.setText(getArguments().getString("CLICK"));
        dialogButtonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return rootView;
    }
}