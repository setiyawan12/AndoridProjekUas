package yayang.setiyawan.uasmobile.presenters

import yayang.setiyawan.uasmobile.contracts.WisataActiviyContract
import yayang.setiyawan.uasmobile.models.Wisata
import yayang.setiyawan.uasmobile.webservices.WisataAPI
import yayang.setiyawan.uasmobile.webservices.WrappedListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityPresenter(v : WisataActiviyContract.View?) : WisataActiviyContract.Interaction {
    private var view : WisataActiviyContract.View? = v
    private var api = WisataAPI.instance()

    override fun allUser(token: String) {
        val request = api.get(token)
        request.enqueue(object : Callback<WrappedListResponse<Wisata>>{
            override fun onFailure(call: Call<WrappedListResponse<Wisata>>, t: Throwable) {
                println("Log: ${t.message} ")
                view?.toast("Cannot connect to server")
            }

            override fun onResponse(
                call: Call<WrappedListResponse<Wisata>>,
                response: Response<WrappedListResponse<Wisata>>
            ) {
                if(response.isSuccessful) {
                    val body = response.body()
                    if (body != null && body.status) {
                        view?.attachToRecycle(body.data)
                    } else {
                        view?.toast("Something went wrong, try again later")
                    }
                }
            }
        })
    }

    override fun destroy() {
        view = null
    }
}