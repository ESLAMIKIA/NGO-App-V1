package com.example.ngo

object CourseRepository {
    val courseList = mutableListOf<Course>()
    val selectedCourses = mutableListOf<Course>()
    private var initialized = false

    fun initializeDefaults() {
        if (initialized) return

        courseList.addAll(
            listOf(
                Course("Android Development", "Learn to build Android apps using Kotlin.", R.drawable.android_course),
                Course("Machine Learning", "Intro to ML algorithms and models.", R.drawable.ml_course),
                Course("Web Development", "Front-end and back-end development with HTML, CSS, JS.", R.drawable.web_course),
                Course("Data Structures", "Master lists, stacks, trees, and more.", R.drawable.data_structures),
                Course("Python Programming", "Beginner to advanced Python concepts.", R.drawable.python_course),
                Course("Cybersecurity Basics", "Fundamentals of keeping systems secure.", R.drawable.cybersecurity),
                Course("React Native", "Build cross-platform mobile apps.", R.drawable.react_native),
                Course("Game Development", "Make 2D/3D games with Unity.", R.drawable.unity_course),
                Course("UI/UX Design", "Principles of design and user experience.", R.drawable.uiux_course),
                Course("Database Management", "Learn SQL and database design.", R.drawable.database_course),
                Course("Git & GitHub", "Version control and collaboration.", R.drawable.git_course),
                Course("Flutter Development", "Create mobile apps with Flutter and Dart.", R.drawable.flutter_course),


            )
        )
        initialized = true
    }
}
