package com.nobeldhar.blooddonation.data.repository

import com.nobeldhar.blooddonation.data.local.daos.DashboardDao
import com.nobeldhar.blooddonation.data.remote.sources.DashboardRemoteDataSource
import com.nobeldhar.blooddonation.utils.performAuthOperation
import com.nobeldhar.blooddonation.utils.performGetOperation
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DashboardRepository @Inject constructor(
        private val remoteDataSource: DashboardRemoteDataSource,
        private val localDataSource: DashboardDao
) {
    fun verifyAuthToken() = performAuthOperation(
            networkCall = { remoteDataSource.verifyAuthToken() }
    )

    fun commentOnPost(comment: String, postId: Int, p_id:Int? = null, reply_id: Int? = null) = performAuthOperation(
        networkCall = { remoteDataSource.commentOnPost(comment, postId, p_id, reply_id) }
    )

    fun getComments(postId: Int) = performAuthOperation(
        networkCall = { remoteDataSource.getComments(postId) }
    )

    fun updateComment(commentId: Int, text: String)  = performAuthOperation(
        networkCall = { remoteDataSource.updateComment(commentId, text) }
    )

    fun deleteComment(commentId: Int)  = performAuthOperation(
        networkCall = { remoteDataSource.deleteComment(commentId) }
    )

    fun getPosts() = performGetOperation(
        databaseQuery = {localDataSource.getPosts()},
        networkCall = { remoteDataSource.getTimeLinePosts()},
        saveCallResult = {localDataSource.insertPosts(it.data)}
    )

    fun likePost(id: Int)= performAuthOperation(
        networkCall = { remoteDataSource.likePost(id) }
    )
}