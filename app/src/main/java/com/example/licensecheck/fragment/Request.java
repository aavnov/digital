package com.example.licensecheck.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.licensecheck.Entity.ListUsers;
import com.example.licensecheck.Interfaces.OnDataPassFromFragmentToActivity;
import com.example.licensecheck.R;
import com.example.licensecheck.http_request.HttpRequestTaskGetLicense;

import java.util.concurrent.ExecutionException;

public class Request extends Fragment {

    public Request() {
        //требуется пустой конструктор
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);






    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_request, container, false);






        /*final TextView textView1 = view.findViewById(R.id.textView1);
        textView1.setTextSize(18);*/
        final EditText editText1 = view.findViewById(R.id.editText1);
        final Button button1 = view.findViewById(R.id.reset1);

        //final TextView textView2 = view.findViewById(R.id.textView2);
        final EditText editText2 = view.findViewById(R.id.editText2);
        final Button button2 = view.findViewById(R.id.reset2);

        final EditText editText3 = view.findViewById(R.id.editText3);
        final Button button3 = view.findViewById(R.id.reset3);


        final TextView textViewRes = view.findViewById(R.id.textViewRes);
        final Button buttonRequest = view.findViewById(R.id.request);




        final View.OnClickListener onClickListenerReset = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Button buttonReset = (Button) v;
                buttonReset.getText();
                System.out.println("!!!!!!!!!!!! buttonRequest.getId() = " + buttonReset.getText());
                editText1.setText("");
                switch (v.getId()) {
                    case R.id.reset1:
                        // кнопка reset1
                        editText1.setText("");
                        break;
                    case R.id.reset2:
                        // кнопка reset2
                        editText2.setText("");
                        break;
                    case R.id.reset3:
                        // кнопка reset3
                        editText3.setText("");
                        break;
                }
            }
        };

        button1.setOnClickListener(onClickListenerReset);
        button2.setOnClickListener(onClickListenerReset);
        button3.setOnClickListener(onClickListenerReset);




// собственно генерация запроса и получение списка лицензий
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("!!!!!!!!!!!!!!!  editText1 = " + editText1.getText());

                ListUsers listUsers = null;
                HttpRequestTaskGetLicense httpRequestTaskGetLicenses = new HttpRequestTaskGetLicense();
                com.example.licensecheck.Entity.Request request = null;

                String name = editText1.getText().toString();
                String inn  = editText2.getText().toString();
                String ogrn = editText3.getText().toString();
                String activity_type = "";
                String asddress = "";
                String date_register = "";
                String date_termination = "";

                try {

                    listUsers = httpRequestTaskGetLicenses.execute(
                                                      name,
                                                      inn,
                                                      ogrn,
                                                      activity_type,
                                                      asddress,
                                                      date_register,
                                                      date_termination).get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

                System.out.println("!!!!!!!!!!!!!!! Request:  ListUsers = " + listUsers.page);


                textViewRes.setText(listUsers.data.length + " позиций найдено");
                System.out.println("!!!!!!!!!!!!!!! Request: listUsers.data.length = " + listUsers.data.length);
                // в соседний фрагмент Intent'ом нельзя передать данные, поэтому используем
                // Interface для передачи сначала в MainActivity, а далее во фрагмент Result
                Request.passDataFromFragmentToMain(listUsers);


            }
        };

        buttonRequest.setOnClickListener(onClickListener);





        return view;//super.onCreateView(inflater, container, savedInstanceState);

    }



    static OnDataPassFromFragmentToActivity dataPasser;
    @Override
    public void onAttach(Activity a) {
        super.onAttach(a);
        dataPasser = (OnDataPassFromFragmentToActivity) a;
    }

    static public void passDataFromFragmentToMain(ListUsers data) {// from HeadingControler
        dataPasser.passDataFromFragmentToActivity(data);
    }

/*
    static public void passAddDataFromFragmentToMain(String data) {// from HeadingControler
        dataPasser.passAddDataFromFragmentToActivity(data);
    }

    static public void passDelDataFromFragmentToMain(Integer maxIdWorkingHours) {// from HeadingControler
        dataPasser.passDelDataFromFragmentToActivity(maxIdWorkingHours);
    }

    static public void passUpdateDataFromFragmentToMain(String data, Integer idWorkingHours) {// from HeadingControler
        dataPasser.passUpdateDataFromFragmentToActivity(data, idWorkingHours);
    }
*/


}
