package com.run.pojo;

import com.run.annotation.Column;
import com.run.annotation.Id;
import com.run.annotation.Table;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author edxuanlen
 * @PROJECT demo
 * @Date 2019/11/8 下午4:36
 * @Version 1.0
 **/

@Table(value = "User")
@Data
public class User implements UserDetails {
//    @Setter @Getter

    private Integer id;
    private String username;
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        auths.add(new SimpleGrantedAuthority("admin"));
        return auths;
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }


    @Id(value = "id")
    public long getId() {
        return id;
    }

    @Override
    @Column(value = "username")
    public String getUsername() {
        return username;
    }

    @Override
    @Column(value = "password")
    public String getPassword() {
        return password;
    }

}
