package org.sid.secservice.service.serviceImpl;

import java.util.List;

import org.sid.secservice.entities.AppRole;
import org.sid.secservice.entities.AppUser;
import org.sid.secservice.repositories.AppRoleRepository;
import org.sid.secservice.repositories.AppUserRepository;
import org.sid.secservice.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private AppUserRepository appUserRepository;

    private AppRoleRepository appRoleRepository;

    public AccountServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
    }

    @Override
    public AppRole addNewRole(AppRole appRole) {
        // TODO Auto-generated method stub
        return appRoleRepository.save(appRole);
    }

    @Override
    public AppUser addNewUser(AppUser appuser) {
        // TODO Auto-generated method stub
        return appUserRepository.save(appuser);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        // TODO Auto-generated method stub
        AppUser appUser = appUserRepository.findByUsername(username);
        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        appUser.getApproles().add(appRole);

    }

    @Override
    public List<AppUser> listUsers() {
        // TODO Auto-generated method stub
        return appUserRepository.findAll();
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        // TODO Auto-generated method stub
        return appUserRepository.findByUsername(username);
    }

}
