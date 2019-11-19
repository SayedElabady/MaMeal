package abadyyy.side_projects.mameal.shared.store.models

import retrofit2.HttpException
import java.io.IOException
import java.net.HttpURLConnection
import javax.inject.Inject

class ErrorHandler @Inject constructor() : IErrorHandler {
    override fun getError(throwable: Throwable): ErrorModel {

        return when (throwable) {

            is IOException -> ErrorModel.NetworkError(throwable)

            is HttpException -> {
                when (throwable.code()) {
                    HttpURLConnection.HTTP_NOT_FOUND -> ErrorModel.NotFound(throwable)

                    HttpURLConnection.HTTP_UNAVAILABLE -> ErrorModel.NotAvailable(throwable)

                    else -> ErrorModel.UnKnownError(throwable)
                }
            }

            else -> ErrorModel.UnKnownError(throwable)
        }
    }

}