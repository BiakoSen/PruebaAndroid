package com.example.pruebaandroid;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    int num_colonia = 0;
    int num_pricesmart = 0;

    Button txt_pricesmart, txt_colonia;

    ImageButton btn_new_evaluation;
    NewEvaluation newEvaluation = new NewEvaluation();

    public FirstFragment() {
        // Required empty public constructor
    }

    public static FirstFragment newInstance() {
        FirstFragment fragment = new FirstFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_first, container, false);
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        btn_new_evaluation = (ImageButton) view.findViewById(R.id.btn_new_evaluation);
        btn_new_evaluation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(newEvaluation);
            }
        });

        txt_colonia = view.findViewById(R.id.eva_colonia);
        txt_pricesmart = view.findViewById(R.id.eva_pricesmart);

        getNumEvaluationsCol();
        getNumEvaluationsPri();

        txt_pricesmart.setText("Evaluaciones: " + num_pricesmart);
        txt_colonia.setText("Evaluaciones: " + num_colonia);

        return view;
    }

    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }

    private void getNumEvaluationsCol() {
        class GetEvaluation extends AsyncTask<Void, Void, Integer> {

            @Override
            protected Integer doInBackground(Void... voids) {
                int evaluationsColonia = DatabaseClient
                        .getInstance(getActivity().getApplicationContext())
                        .getAppDatabase()
                        .evaluationsDao()
                        .getAll_colonia();
                return evaluationsColonia;
            }

            @Override
            protected void onPostExecute(Integer evaluations) {
                super.onPostExecute(evaluations);

                num_colonia = evaluations;

            }
        }
        GetEvaluation gt = new GetEvaluation();
        gt.execute();
    }

    private void getNumEvaluationsPri() {
        class GetEvaluation extends AsyncTask<Void, Void, Integer> {

            @Override
            protected Integer doInBackground(Void... voids) {
                int evaluationsPricesmart = DatabaseClient
                        .getInstance(getActivity().getApplicationContext())
                        .getAppDatabase()
                        .evaluationsDao()
                        .getAll_pricesmart();
                return evaluationsPricesmart;
            }

            @Override
            protected void onPostExecute(Integer evaluations) {
                super.onPostExecute(evaluations);

                num_pricesmart = evaluations;

            }
        }
        GetEvaluation gt = new GetEvaluation();
        gt.execute();
    }
}