package com.example.spacexassignment.network

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.CallAdapter
import retrofit2.Call
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class FlowCallAdapterFactory : CallAdapter.Factory() {
    override fun get(returnType: Type, annotations: Array<Annotation>, retrofit: Retrofit): CallAdapter<*, *>? {
        if (getRawType(returnType) != Flow::class.java) {
            return null
        }
        val responseType = getParameterUpperBound(0, returnType as ParameterizedType)
        return FlowCallAdapter<Any>(responseType)
    }
}

class FlowCallAdapter<R>(private val responseType: Type) : CallAdapter<R, Flow<R>> {
    override fun responseType() = responseType

    override fun adapt(call: Call<R>): Flow<R> {
        return flow {
            emit(call.execute().body() ?: throw IllegalArgumentException("Response body is null"))
        }
    }
}

