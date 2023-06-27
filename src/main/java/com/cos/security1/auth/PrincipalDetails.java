package com.cos.security1.auth;

// 시큐리티가 /login 주소 요청이 오면 낚아채서 로그인을 진행시킨다.
// 로그인 진행이 완료되면 사큐리티 session을 만들어준다. (Security ContextHolder에 세션 정보 저장함)
// 오브젝트 => Authentication 타입 객체
// Authentication 안에 User 정보가 있어야 한다
// User 오브젝트 타입 => UserDetails 타입 객체

// Security Session => Authentication 객체 => UserDetails(PrincipalDetails) 타입

import com.cos.security1.model.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
@Data
public class PrincipalDetails implements UserDetails {

    private User user; // 컴포지션 (상속 x)

    public PrincipalDetails(User user) {
        super();
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collet = new ArrayList<GrantedAuthority>();
        collet.add(()->{ return user.getRole();});
        return collet;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    @Override
    public boolean isEnabled() { // 계정 활성화 여부
        // 사이트에서 1년동안 회원이 로그인을 하지 않으면 휴먼 계정으로 전환하기로 함
        // user.getLoginDate(); // 로그인 한 날짜를 가져옴
        // 현재 시간 - 로그인 시간 => 1년 초과할 시 return false; 로 설정
        return true;
    }
}