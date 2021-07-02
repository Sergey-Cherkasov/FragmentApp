package pt.svcdev.fragmentapp.repository

import pt.svcdev.fragmentapp.classesData
import pt.svcdev.fragmentapp.model.ClassesModel

class ClassesRepositoryImpl : Repository<List<ClassesModel>> {
    override suspend fun getData(): List<ClassesModel> = classesData
}