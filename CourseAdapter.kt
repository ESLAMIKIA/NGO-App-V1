import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ngo.Course
import com.example.ngo.R

class CourseAdapter(private val courseList: MutableList<Course>, function: (Any?) -> Unit) :
    RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    inner class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.courseTitle)
        val desc: TextView = itemView.findViewById(R.id.courseDesc)
        val image: ImageView = itemView.findViewById(R.id.courseImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_course, parent, false)
        return CourseViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courseList[position]
        holder.title.text = course.title
        holder.desc.text = course.description
        holder.image.setImageResource(course.imageResId)
    }

    override fun getItemCount(): Int = courseList.size
}
