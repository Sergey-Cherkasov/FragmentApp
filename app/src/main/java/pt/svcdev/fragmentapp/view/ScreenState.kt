package pt.svcdev.fragmentapp.view

import pt.svcdev.fragmentapp.model.ClassesModel
import pt.svcdev.fragmentapp.model.HomeworkModel

sealed class ClassesState {
    data class Success(val result: List<ClassesModel>) : ClassesState()
    data class Error(val error: Throwable) : ClassesState()
}

sealed class HomeworkState {
    data class Success(val result: List<HomeworkModel>) : HomeworkState()
    data class Error(val error: Throwable) : HomeworkState()
}