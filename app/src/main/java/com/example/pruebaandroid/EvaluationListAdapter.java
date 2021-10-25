package com.example.pruebaandroid;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EvaluationListAdapter extends RecyclerView.Adapter<EvaluationListAdapter.TasksViewHolder> {

    private Context mCtx;
    private List<Evaluations> evaluationsList;

    public EvaluationListAdapter(Context mCtx, List<Evaluations> evaluationsList) {
        this.mCtx = mCtx;
        this.evaluationsList = evaluationsList;
    }

    @Override
    public TasksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_evaluation, parent, false);
        return new TasksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TasksViewHolder holder, int position) {
        Evaluations t = evaluationsList.get(position);
        holder.textViewTask.setText(t.getEvaluator_name());
        holder.textViewDesc.setText(t.getDate_eva());
        holder.textViewFinishBy.setText("aa");
        holder.textViewStatus.setText(t.getCommerce());

    }

    @Override
    public int getItemCount() {
        return evaluationsList.size();
    }

    class TasksViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewStatus, textViewTask, textViewDesc, textViewFinishBy;

        public TasksViewHolder(View itemView) {
            super(itemView);

            textViewStatus = itemView.findViewById(R.id.textViewStatus);
            textViewTask = itemView.findViewById(R.id.textViewTask);
            textViewDesc = itemView.findViewById(R.id.textViewDesc);
            textViewFinishBy = itemView.findViewById(R.id.textViewFinishBy);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
//            Evaluations task = evaluationsList.get(getAdapterPosition());
//
//            Intent intent = new Intent(mCtx, UpdateTaskActivity.class);
//            intent.putExtra("task", task);
//
//            mCtx.startActivity(intent);
        }
    }
}

