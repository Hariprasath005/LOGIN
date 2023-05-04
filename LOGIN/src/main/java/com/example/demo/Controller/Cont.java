package com.example.demo.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.modelD;
import com.example.demo.Model.modelL;
import com.example.demo.Service.Ser;



@RestController
public class Cont {
	@Autowired
	Ser cusservice;
	
	@PostMapping("/pom")
	public String create(@RequestBody modelD customer)
	{
		return cusservice.addCustomer(customer);
	}
	
	
	@GetMapping("/gm")
	public List<modelD> read()
	{
		return cusservice.getCustomer();
	}
	
	
	@GetMapping("/{id}")
	public Optional <modelD> readById(@PathVariable int id)
	{
		return cusservice.getCustomerById(id);
	
	}
	
	
	@PutMapping("/pum")
	public String update(@RequestBody modelD customer)
	{
		return cusservice.updateCustomer(customer);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id)
	{
		return cusservice.deleteById(id);
	}
	
	
	@GetMapping("/service")
	public List<modelD> getProSorted(@RequestParam String field)
	{
		return cusservice.getProDetails(field);
	}
		
		
	@GetMapping("/service/{offset}/{pagesize}")
	public List<modelD> getProwithPagination(@PathVariable int offset,@PathVariable int pagesize)
	{
		return cusservice.getProwithPag(offset,pagesize);
	}
	
	
	@PostMapping("/pomL")
	public String login(@RequestBody Map<String,String> loginData)
	{
		String uname=loginData.get("uname");
		String pwd=loginData.get("pwd");
		String result=cusservice.checkLogin(uname,pwd);
		return result;
    }
	
	
	@PostMapping("/addL")
	public modelL AddUser(@RequestBody modelL mod)
	{
		return cusservice.addUser(mod);
	}
	
	
	@GetMapping("/gmL")
	public List<modelL> listAll()
	{
		return cusservice.getUser();
	}
	//delete
		@DeleteMapping("/deletemapping1/{name}")
		public String deleteCustByName(@PathVariable("name") String name)
		{
			 int result=cusservice.deleteCustByName(name);
			 if(result>0)
				 return "Customer record is deleted";
			 else
				 return"No record found";
		}
		
		
		//update
		@PutMapping("/updatebyquery/{city}/{name}")
		public String updateCust(@PathVariable ("city")String city,@PathVariable ("name")String name)
		{
			int res=cusservice.updateCust(city, name);
			if(res>0)
				return "Museum record updated";
			else
				return "Problem occured while updating";
		}

		//fetchbynamestart
		@GetMapping("/prefixname")
		public List<modelD> fetchCustModelByNamePrefix(@RequestParam String prefix)
		{
			 return cusservice.fetchCustByNamePrefix(prefix);
		}

		

		//fetchbtnameend
		@GetMapping("/Suffixname")
		public List<modelD>fetchCustByNameSuffix(@RequestParam String suffix)
		{
			return cusservice.fetchCustByNameSuffix(suffix);
		}
		
		
		
		

		
		
		//native
		@GetMapping("fetchbystaff/{weight}")
		public List<modelD> fetchCustByWeight(@PathVariable String weight){
			return cusservice.fetchCustByWeight(weight);
		}


		//query1
		@GetMapping("/getMuseumByMname/{name}/{operation}")
		public List<modelD> getCustByName(@PathVariable String name,@PathVariable String operation)
		{
			return cusservice.getCustByName(name, operation);
		}



		//query2
		@GetMapping("/getMuseumByMname/{name}")
		public List<modelD> getCustByName(@PathVariable String name)
		{
			return cusservice.getCustByName(name);
		}
	
	
		
}