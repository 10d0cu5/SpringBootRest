package com.demo.restapi;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Handling create, update, read and find of objects
 */
interface UserRepository extends JpaRepository<User,Long> { //Spring Data Interface with domain type Employee and id type as Long



}
