package com.project.fooddeliveryservice.database;

import com.project.fooddeliveryservice.data.*;
import com.project.fooddeliveryservice.repository.*;
import org.aspectj.weaver.ast.Or;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderFoodRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CompanyFoodCategoryRepository foodCategoryRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderFoodRepository orderFoodRepository;
    @Autowired
    private FoodRepository foodRepository;

    private User createUser() {
        User user = new User();
        user.setFirstName("Jon");
        user.setLastName("Jones");
        user.setAddress("Hawaii, Oahu");
        user.setPhone("+77777777777");
        user.setPassword("bones");
        user.setRole(1);
        return user;
    }

    private Order createOrder(User user) {
        Order order = new Order();
        order.setUser(user);
        order.setOrderTime(LocalDateTime.of(2023, 10, 15, 14, 30));
        order.setTotalCost(13.5);
        order.setAddress("Hawaii, Oahu");
        return order;
    }

    private Company createCompany() {
        Company company = new Company();
        company.setCategory("Fast Food Restaurant");
        company.setName("Chum Bucket");
        company.setLogoPath("www.example.com/images/image_123.png");
        return company;
    }

    private CompanyFoodCategory createFoodCategory(Company company) {
        CompanyFoodCategory foodCategory = new CompanyFoodCategory();
        foodCategory.setCompany(company);
        foodCategory.setName("Burgers");
        return foodCategory;
    }

    private OrderFood createOrderFood(Order order, Food food) {
        OrderFood orderFood = new OrderFood();
        orderFood.setFood(food);
        orderFood.setOrder(order);
        orderFood.setQuantity(3);
        orderFood.setSubtotal(9.3);
        return orderFood;
    }

    private Food createFood(CompanyFoodCategory foodCategory) {
        Food food = new Food();
        food.setCompanyFoodCategory(foodCategory);
        food.setPrice(10.21);
        food.setName("Krabby Patty");
        food.setDescription("Krabby Patty best offer from our company!");
        food.setImagePath("www.example.com/images/krabby_patty.png");
        return food;
    }

    @Test
    @DisplayName("Create OrderFood")
    public void itShouldCreateOrderFood() {
        User user = createUser();
        userRepository.save(user);
        Order order = createOrder(user);
        orderRepository.save(order);
        Company company = createCompany();
        companyRepository.save(company);
        CompanyFoodCategory foodCategory = createFoodCategory(company);
        foodCategoryRepository.save(foodCategory);
        Food food = createFood(foodCategory);
        foodRepository.save(food);

        OrderFood orderFood = createOrderFood(order, food);

        OrderFoodKey orderFoodKey = new OrderFoodKey();
        orderFoodKey.setFoodId(food.getId());
        orderFoodKey.setOrderId(orderFoodKey.getOrderId());

        orderFood.setId(orderFoodKey);
        orderFoodRepository.save(orderFood);

        ExampleMatcher idMatcher = ExampleMatcher.matching()
                .withMatcher("id", ignoreCase());

        Example<OrderFood> example = Example.of(orderFood, idMatcher);
        boolean condition = orderFoodRepository.exists(example);

        assertTrue(condition);
    }
}
