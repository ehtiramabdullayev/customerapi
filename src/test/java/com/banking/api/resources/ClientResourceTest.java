package com.banking.api.resources;

import com.banking.api.dtos.AccountReqDTO;
import com.banking.api.dtos.FreshCustomerDTO;
import com.banking.api.dtos.FreshCustomerResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.RequestResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


/**
 * Created by Master on 2/20/2018.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ClientResource.class)
public class ClientResourceTest{


    @Autowired
    private MockMvc mvc;

@MockBean
private ClientResource clientResource;

    @Before
    public void setUp() throws Exception{
        mvc= MockMvcBuilders.standaloneSetup(clientResource).build();
    }

    @Test
    public void signupCustomer() throws Exception {
        FreshCustomerDTO customerDTO = new FreshCustomerDTO();
        customerDTO.setEmail("a@asdf.com");
        customerDTO.setPassword("12345");
        FreshCustomerResponseDTO responseDTO = clientResource.signupCustomer(customerDTO);

        System.out.println(" >>>> " + new ObjectMapper().writeValueAsString(responseDTO));
       mvc.perform(MockMvcRequestBuilders.post("/banking/customer").
                       contentType(MediaType.APPLICATION_JSON).
               accept(MediaType.APPLICATION_JSON).
               content(new ObjectMapper().writeValueAsString(responseDTO))
       ).andExpect(MockMvcResultMatchers.status().isCreated());


    }

    @Test
    public void withdraw() throws Exception {
        //AccountReqDTO reqDTO =
        //clientResource.withdraw();

    }

    @Test
    public void deposit() throws Exception {


    }

    @Test
    public void getBalance() throws Exception {

    }

    @Test
    public void getStatements() throws Exception {

    }







}