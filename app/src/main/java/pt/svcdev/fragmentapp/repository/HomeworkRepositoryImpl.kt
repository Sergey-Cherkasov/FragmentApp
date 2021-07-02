package pt.svcdev.fragmentapp.repository

import pt.svcdev.fragmentapp.homeworkData
import pt.svcdev.fragmentapp.model.HomeworkModel

class HomeworkRepositoryImpl : Repository<List<HomeworkModel>> {
    override suspend fun getData(): List<HomeworkModel> = homeworkData
}