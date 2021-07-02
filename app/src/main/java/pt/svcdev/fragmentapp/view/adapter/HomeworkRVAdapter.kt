package pt.svcdev.fragmentapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pt.svcdev.fragmentapp.R
import pt.svcdev.fragmentapp.model.HomeworkModel

class HomeworkRVAdapter : RecyclerView.Adapter<HomeworkRVAdapter.ViewHolder>() {

    private var homeworkList: List<HomeworkModel> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.rv_homework_item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(homeworkList[position])

    override fun getItemCount(): Int = homeworkList.size

    fun setData(homeworkList: List<HomeworkModel>) {
        this.homeworkList = homeworkList
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val txtHomeworkName = view.findViewById<TextView>(R.id.homework_class_name)
        private val txtHomeworkTime = view.findViewById<TextView>(R.id.homework_time)
        private val txtHomeworkDescription = view.findViewById<TextView>(R.id.homework_description)

        fun bind(homework: HomeworkModel) {
            txtHomeworkName.text = homework.name
            txtHomeworkTime.text = homework.timeExpire
            txtHomeworkDescription.text = homework.description
        }
    }
}