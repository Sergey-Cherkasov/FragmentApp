package pt.svcdev.fragmentapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pt.svcdev.fragmentapp.R
import pt.svcdev.fragmentapp.model.ClassesModel

class ClassesRVAdapter : RecyclerView.Adapter<ClassesRVAdapter.ViewHolder>() {

    private var classesList: List<ClassesModel> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.rv_classes_item, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(classesList[position])

    override fun getItemCount(): Int = classesList.size

    fun setData(classesList: List<ClassesModel>) {
        this.classesList = classesList
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val txtClassName = view.findViewById<TextView>(R.id.class_name)
        private val txtClassTime = view.findViewById<TextView>(R.id.class_time)

        fun bind(clazz: ClassesModel) {
            txtClassName.text = clazz.name
            txtClassTime.text = String.format("${clazz.begin} - ${clazz.end}")
        }
    }
}