/*
 * modelo user
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

/**
 *
 * @author kewining
 */
public class user {
    private int id_user;
    private String name;
    private String email;
    private String username;
    private String password;
    private int id_status;
    
    public int getid_user()
    {
        return id_user;
    }
    public void setid_user(int id_user)
    {
        this.id_user=id_user;
    }
    
    public String getname()
    {
        return name;
    }
    public void setname(String name)
    {
        this.name=name;
    }
    
    public String getemail()
    {
        return email;
    }
    public void setemail(String email)
    {
        this.email=email;
    }
    
    public String getusername()
    {
        return username;
    }
    public void setusername(String username)
    {
        this.username=username;
    }
    
    public String getpassword()
    {
        return password;
    }
    public void setpassword(String password)
    {
        this.password=password;
    }
    
    public int getid_status()
    {
        return id_status;
    }
    public void setid_status(int id_status)
    {
        this.id_status=id_status;
    }
}