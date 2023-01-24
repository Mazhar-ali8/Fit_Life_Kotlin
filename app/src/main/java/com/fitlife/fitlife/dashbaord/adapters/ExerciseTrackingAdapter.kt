package com.fitlife.fitlife.dashbaord.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fitlife.fitlife.databinding.CustomRowForExerciseTrackingBinding
import com.fitlife.fitlife.room_db.entities.ExerciseDetailsEntitiy

class ExerciseTrackingAdapter(val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var exercisesDetails: List<ExerciseDetailsEntitiy>


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: CustomRowForExerciseTrackingBinding = CustomRowForExerciseTrackingBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return NotificationViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as NotificationViewHolder).bind(position)
    }

    override fun getItemCount(): Int {
        return exercisesDetails.size
    }

    inner class NotificationViewHolder(view: CustomRowForExerciseTrackingBinding) :
        RecyclerView.ViewHolder(view.root) {
        private var exerciseDate = view.datesOfExercise
        private var arrowIndicator = view.ivGroupIndicator
        private var exerciseDetaillayout = view.detailLL
        private var exerciseName = view.exercisesNames
        private var userName = view.UserName
        private var userEmail = view.Useremail
        private var setstv = view.setstv
        private var weighttv = view.weightsTv
        private var repstv = view.repititionTv
        private var exerciseImage = view.exericeImage
        private var exerciseDescription = view.exericeDescription


        @SuppressLint("SetTextI18n")
        fun bind(position: Int) {
            val exercisesList = exercisesDetails[position]
            exerciseDate.text = exercisesList.date
            exerciseName.text = exercisesList.exersiseName
            userName.text = exercisesList.username
            userEmail.text = exercisesList.useremail
            setstv.text = exercisesList.sets
            weighttv.text = exercisesList.weight + "kg"
            repstv.text = exercisesList.reps
            exerciseImage.setImageResource(exercisesList.exerciseImage!!.toInt())
            exerciseDescription.text = exercisesList.exerciseDescription
            arrowIndicator.setOnClickListener {

                if (exerciseDetaillayout.visibility == View.GONE) {
                    exerciseDetaillayout.visibility = View.VISIBLE
                } else if (exerciseDetaillayout.visibility == View.VISIBLE)
                    exerciseDetaillayout.visibility = View.GONE
            }
        }
    }

    fun setExerciseList(
        exerciseList: List<ExerciseDetailsEntitiy>,
    ) {
        this.exercisesDetails = exerciseList
    }
}