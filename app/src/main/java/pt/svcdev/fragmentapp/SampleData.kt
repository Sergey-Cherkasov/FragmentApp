package pt.svcdev.fragmentapp

import pt.svcdev.fragmentapp.model.ClassesModel
import pt.svcdev.fragmentapp.model.HomeworkModel

val classesData = listOf(
    ClassesModel("History", "08:00", "08:45"),
    ClassesModel("Literature", "08:50", "09:35"),
    ClassesModel("Mathematic", "09:40", "10:25")
)

val homeworkData = listOf(
    HomeworkModel("History", "12/07/2021", "Draw a diagram of the offensive of the Soviet troops"),
    HomeworkModel("Literature", "15/07/2021", "Learn a poem"),
    HomeworkModel("Mathematic", "11/07/2021", "Solve the integral equation")
)