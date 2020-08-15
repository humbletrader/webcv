package com.example.webcv.user;

import com.example.webcv.certification.CertificationModel;
import com.example.webcv.experience.ExperienceModel;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Optional;

@Service
@Primary //stupid way of enforcing this bean
public class MockUserService implements UserService,
        BeanFactoryAware, BeanNameAware, ApplicationContextAware, InitializingBean ,
        BeanPostProcessor {

    public MockUserService(){
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        System.out.println("------------   mock service -------------------------");
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
    }

    @Override
    public Iterable<UserModel> retrieveAllUsers() {
        return null;
    }

    @Override
    public Optional<UserModel> retrieveUser(Integer userId) {
        return Optional.empty();
    }

    @Override
    public Integer newUser(UserModel userModel) {
        return null;
    }

    @Override
    public Integer updateUser(UserModel userModel) throws UserDoesNotExistException {
        return null;
    }

    @Override
    public void deleteUser(Integer userId) {

    }

    @Override
    public Optional<Integer> addExperience(Integer userId, ExperienceModel newExperience) {
        return Optional.empty();
    }

    @Override
    public Optional<Integer> updateExperience(Integer userId, ExperienceModel updatedExperience) {
        return Optional.empty();
    }

    @Override
    public Optional<Integer> deleteExperience(Integer userId, Integer experienceId){
        return Optional.empty();
    }

    @Override
    public Optional<Integer> addCertification(Integer userId, CertificationModel newCertification){
        return Optional.empty();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("this is called the second - setting bean factory");
        System.out.println("setting bean factory to my MockUserService because it is BeanFactoryAware");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("this is called first - setting bean name");
        System.out.println("setting bean name as "+s+" because my MockService is BeanNameAware");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("this is called the fourth - postConstruct");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("pre destroy called");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("this is called the third - setting the application context");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("this is called the fifth - afterPropertiesSet");
    }
}
