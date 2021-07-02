package pt.svcdev.fragmentapp.repository

interface Repository<T> {
    suspend fun getData(): T
}