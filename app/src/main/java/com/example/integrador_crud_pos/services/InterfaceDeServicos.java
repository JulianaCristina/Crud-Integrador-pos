package com.example.integrador_crud_pos.services;

//import com.example.integrador_crud_pos.dto.DtoAuthLogin;
//import com.example.integrador_crud_pos.dto.DtoAuthLoginReturn;
//import com.example.integrador_crud_pos.dto.DtoGetProduct;

import com.example.integrador_crud_pos.dto.UserDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface InterfaceDeServicos {

//    @POST("/auth/login")
//    Call<DtoAuthLoginReturn> autenticar(@Body DtoAuthLogin dtoAuthLogin);
//
//    @POST("/auth/refresh_token")
//    Call<DtoAuthLoginReturn> refreshToken(@Header("Authorization") String authorization);
//
//    @POST("/users")
//    Call<DtoUser> cadastrarUsuario(@Body DtoUser dtoUser);
//
//    @GET("products")
//    Call<DtoGetProduct> todosProdutos();

    @POST("/users")
    Call<UserDTO> cadastrarUsuario(@Body UserDTO userDTO);


}

