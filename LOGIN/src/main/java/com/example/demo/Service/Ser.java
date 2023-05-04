package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.modelD;
import com.example.demo.Model.modelL;
import com.example.demo.Repository.RepoD;
import com.example.demo.Repository.RepoL;


@Service
public class Ser {
	
	@Autowired
	RepoD repository;
	
	@Autowired
	RepoL repositoryL;
	
	public String addCustomer(modelD customer)
	{
		repository.save(customer);
		return "Added successfully";
	}
	public List<modelD > getCustomer()
	{
		return repository.findAll();
		
	}
	public Optional<modelD > getCustomerById(int id)
	{
		return repository.findById(id);
	}
	public String updateCustomer(modelD  customer)
	{
		repository.save(customer);
		return "Updated successfully";
	}
	public String deleteById(int id)
	{
		repository.deleteById(id);
		return "Deleted successfully";
	}
	
	public List<modelD > getProDetails(@RequestParam String field)
	{
		return repository.findAll(Sort.by(Direction.ASC,field));
	}

	public List<modelD > getProwithPag(int offset, int pagesize)
	{
		Page<modelD > page=repository.findAll(PageRequest.of(offset, pagesize));
		return page.getContent();
	}
	
	public String checkLogin(String uname,String pwd)
	{
		modelL user=repositoryL.findByuname(uname);
		if(user==null)
		{
			return "Invalid Details";
		}
		else
		{
			if(user.getPwd().equals(pwd))
			{
				return "Login successful";
			}
			else
			{
				return "Login failed";
			}
		}
	}
	
	public modelL addUser(modelL mod)
	{
		return repositoryL.save(mod);
	}
	
	
	public List<modelL> getUser()
	{
		return repositoryL.findAll();
	}

}

