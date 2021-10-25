package com.example.pruebaandroid;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PointsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PointsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters

    private String date = "hoy";
    private String name = "Juan";
    private String commerce = "comercio";

    private EditText num_clients, num_services;

    private Switch swt_1, swt_2, swt_3, swt_4, swt_5;

    public PointsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PointsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PointsFragment newInstance(String param1, String param2) {
        PointsFragment fragment = new PointsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            date = getArguments().getString("date");
            name = getArguments().getString("name");
            commerce = getArguments().getString("commerce");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_points, container, false);

        num_clients = view.findViewById(R.id.edit_clients);
        num_services = view.findViewById(R.id.edit_services);
        swt_1 = view.findViewById(R.id.swt_clouthes);
        swt_2 = view.findViewById(R.id.swt_nails);
        swt_3 = view.findViewById(R.id.swt_hair);
        swt_5 = view.findViewById(R.id.swt_mask);
        swt_4 = view.findViewById(R.id.swt_courtesy);

        view.findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveEvaluation();
            }
        });

        return view;
    }

    private void saveEvaluation() {
//        final String sTask = editTextTask.getText().toString().trim();
//        final String sDesc = editTextDesc.getText().toString().trim();
//        final String sFinishBy = editTextFinishBy.getText().toString().trim();

        if (num_clients.getText().toString().isEmpty()) {
            num_clients.setError("Numero de clientes requerido");
            num_clients.requestFocus();
            return;
        }

        if (num_services.getText().toString().isEmpty()) {
            num_services.setError("Numero de servicios requeridos");
            num_services.requestFocus();
            return;
        }

        final int sNum_clients = Integer.parseInt(num_clients.getText().toString().trim());
        final int sNum_services = Integer.parseInt(num_services.getText().toString().trim());

        final Boolean bSwt_1 = swt_1.isChecked();
        final Boolean bSwt_2 = swt_2.isChecked();
        final Boolean bSwt_3 = swt_3.isChecked();
        final Boolean bSwt_4 = swt_4.isChecked();
        final Boolean bSwt_5 = swt_5.isChecked();

        class SaveTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {

                //creating a task
                Evaluations evaluations = new Evaluations();

                evaluations.setCommerce(commerce);
                evaluations.setClean_clothes(bSwt_1);
                evaluations.setNails(bSwt_2);
                evaluations.setGroomed_hair(bSwt_3);
                evaluations.setHat(false);
                evaluations.setMask(bSwt_4);
                evaluations.setCourtesy(bSwt_5);
                evaluations.setClients_served(sNum_clients);
                evaluations.setServices(sNum_services);
                evaluations.setEvaluator_name(name);
                evaluations.setDate_eva(date);

                //adding to database
                DatabaseClient.getInstance(getActivity().getApplicationContext()).getAppDatabase()
                        .evaluationsDao()
                        .insert(evaluations);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);

                Toast.makeText(getContext(), "Se a guardado la Evaluacion", Toast.LENGTH_SHORT).show();
            }
        }

        SaveTask st = new SaveTask();
        st.execute();
    }
}