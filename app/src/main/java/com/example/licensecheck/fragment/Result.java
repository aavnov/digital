package com.example.licensecheck.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.licensecheck.Entity.Data;
import com.example.licensecheck.Entity.ListUsers;
import com.example.licensecheck.Interfaces.DataPassFromActivityToFragment;
import com.example.licensecheck.R;
import com.example.licensecheck.adapter.RVAdapter;
import com.example.licensecheck.provider.ApplicationContextProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Result extends Fragment implements DataPassFromActivityToFragment {

    Context context = ApplicationContextProvider.getContext();

    RecyclerView rv;

    String[] dataTest = { "Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
            "Костя", "Игорь", "Анна", "Денис", "Андрей" };

    Data[] data;


    //List<String> wordList = Arrays.asList(words);
    //Data data1 = new Data("1","2", "3", "4", "5");
    com.example.licensecheck.Entity.Data data2 = new Data();

    public List<Data> datas = new ArrayList(); // = Arrays.asList(dataTest);



    ArrayAdapter<String> adapter;
    RVAdapter adapterRV;


    @Override
    public void passDataFromActivityToFragment(ListUsers listUsers) {

        System.out.println("!!!!!!!!!!!!!!! Hello from Result extends Fragment implements DataPassFromActivityToFragment ");

        data = listUsers.data;

        int i = 0;
        datas.clear();
        for (Data data  : listUsers.data) {

            datas.add(data);

            System.out.println("                     ");//
            System.out.println(" !!!!!!!!!!!!!!!!!!!Result data.id         = " + data.id);//getHeaders().getDate());
            System.out.println(" !!!!!!!!!!!!!!!!!!!Result data.email      = " + data.email);//getHeaders().getDate());
            System.out.println(" !!!!!!!!!!!!!!!!!!!Result data.first_name = " + data.first_name);//getHeaders().getDate());
            System.out.println(" !!!!!!!!!!!!!!!!!!!Result data.last_name  = " + data.last_name);//getHeaders().getDate());
            System.out.println(" !!!!!!!!!!!!!!!!!!!Result data.avatar     = " + data.avatar);//getHeaders().getDate());
            System.out.println("                       ");//
            dataTest[i++] = data.email;
        }

        /*Adapter adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1, dataTest);*/
         adapter.notifyDataSetChanged();
         adapterRV.notifyDataSetChanged();




    }



    public Result() {
        //требуется пустой конструктор
    }




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        data2.setId("1");
        data2.setEmail("2");
        data2.setFirst_name("3");
        data2.setLast_name("4");
        data2.setAvatar("5");


        datas.add(data2);


        // создаем адаптер
        adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1, dataTest);

        adapterRV = new RVAdapter(datas);



    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        // находим список
        ListView lvMain = (ListView) view.findViewById(R.id.lvMain);

        // присваиваем адаптер списку
        lvMain.setAdapter(adapter);



        rv = (RecyclerView)view.findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(context);
        rv.setLayoutManager(llm);
        rv.setAdapter(adapterRV);

        //initializeAdapter();



        return view;

    }



    void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(datas);
        rv.setAdapter(adapter);
    }











}
