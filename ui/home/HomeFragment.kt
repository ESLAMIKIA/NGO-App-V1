package com.example.ngo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import CourseAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ngo.CourseRepository
import com.example.ngo.R


class HomeFragment : Fragment() {
    data class Course(
        val title: String,
        val description: String,
        val imageResId: Int
    )


    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CourseAdapter
    private lateinit var courseList: List<Course>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)


        recyclerView = view.findViewById(R.id.recyclerViewCourses)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        (requireActivity() as AppCompatActivity).supportActionBar?.hide()

        CourseRepository.initializeDefaults() // ← این خط رو اضافه کن

        return view
    }

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val view = inflater.inflate(R.layout.fragment_home, container, false)
//
//        recyclerView = view.findViewById(R.id.recyclerViewCourses)
//        recyclerView.layoutManager = LinearLayoutManager(requireContext())
//
//        courseList = listOf(
//            Course("Android Development", "Learn to build Android apps using Kotlin.", R.drawable.android_course),
//            Course("Machine Learning", "Intro to ML algorithms and models.", R.drawable.ml_course),
//            Course("Web Development", "Front-end and back-end development with HTML, CSS, JS.", R.drawable.web_course),
//            Course("Data Structures", "Master lists, stacks, trees, and more.", R.drawable.data_structures),
//            Course("Python Programming", "Beginner to advanced Python concepts.", R.drawable.python_course),
//            Course("Cybersecurity Basics", "Fundamentals of keeping systems secure.", R.drawable.cybersecurity),
//            Course("React Native", "Build cross-platform mobile apps.", R.drawable.react_native),
//            Course("UI/UX Design", "Principles of design and user experience.", R.drawable.uiux_course),
//            Course("Database Management", "Learn SQL and database design.", R.drawable.database_course),
//            com.example.ngo.Course("Artificial Intelligence", "Explore AI and deep learning.", R.drawable.ai_course),
//            com.example.ngo.Course("Git & GitHub", "Version control and collaboration.", R.drawable.git_course),
//            com.example.ngo.Course("Cloud Computing", "AWS, Azure, and cloud services.", R.drawable.cloud_course),
//            com.example.ngo.Course("Flutter Development", "Create mobile apps with Flutter and Dart.", R.drawable.flutter_course),
//            com.example.ngo.Course("DevOps", "CI/CD pipelines and automation.", R.drawable.devops_course),
//            com.example.ngo.Course("Game Development", "Make 2D/3D games with Unity.", R.drawable.unity_course)
//        )

//        adapter = CourseAdapter(courseList)
//        recyclerView.adapter = adapter

//        return view
//    }
    override fun onResume() {
        super.onResume()

        val courseList = CourseRepository.courseList

        var courseAdapter = CourseAdapter(courseList) {
            Toast.makeText(requireContext(), "Course selected!", Toast.LENGTH_SHORT).show()
        }

        recyclerView.adapter = courseAdapter
    }
}
