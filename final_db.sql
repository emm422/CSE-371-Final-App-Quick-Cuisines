-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 04, 2021 at 02:01 AM
-- Server version: 5.7.24
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `final_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_advice`
--

CREATE TABLE `tb_advice` (
  `id` int(100) NOT NULL,
  `keyword` varchar(50) NOT NULL,
  `response` varchar(2000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_advice`
--

INSERT INTO `tb_advice` (`id`, `keyword`, `response`) VALUES
(3, 'grains', 'Grains food group:_Grains contain carbohydrates, fibers, vitamins, and minerals._Half of the grains you eat should be whole grains as they are much healthier than regular grains._6 servings of grains are suggested per day.'),
(4, 'fruit', 'Fruit food group:_Fruits are great sources of vitamins and potassium._They are also low in fats and high in fibers._Choose to eat whole fruits as opposed to juices._2 servings are recommended daily.'),
(5, 'vegetables', 'Vegetable food group:_Vegetables are a great source of vitamins, folate, iron, and magnesium._They are also low in fats and high in fibers._Dark green and deep orange vegetables are the best._2.5 servings are recommended daily.\r\n'),
(6, 'dairy', 'Dairy food group:_Diary is a good source of calcium and vitamins, and it promotes strong bone growth._Low fat or non-fat options are the healthiest._3 servings are recommended daily.'),
(7, 'protein', 'Protein food group:_The protein food group consists of foods like meats, fish, and beans._When eating poultry, choose a lean cut and remove the skin._5.5 ounce equivalents of protein are recommended per day.');

-- --------------------------------------------------------

--
-- Table structure for table `tb_recipes`
--

CREATE TABLE `tb_recipes` (
  `id` int(11) NOT NULL,
  `link` varchar(200) NOT NULL,
  `title` varchar(50) NOT NULL,
  `time` int(3) NOT NULL,
  `ingredients` varchar(200) NOT NULL,
  `type` varchar(10) NOT NULL,
  `meat` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_recipes`
--

INSERT INTO `tb_recipes` (`id`, `link`, `title`, `time`, `ingredients`, `type`, `meat`) VALUES
(3, 'https://spoonuniversity.com/recipe/maple-roasted-butternut-squash', 'Maple Roasted Butternut Squash', 30, 'butternut_squash,olive_oil,maple_syrup,brown_sugar,cinnamon,sage,salt,pepper', 'sweet', 'none'),
(5, 'https://spoonuniversity.com/recipe/these-smores-chicken-and-waffles-are-almost-too-good', 'S\'mores Chicken and Waffles', 75, 'flour,cocoa_powder,baking_powder,baking_soda,salt,eggs,milk,vegetable_oil,apple_sauce,sugar,chocolate_chips,marshmallow,graham_crackers,chicken_breasts,maple_syrup,coconut_oil', 'sweet', 'chicken'),
(9, 'https://www.tasteofhome.com/recipes/easy-butternut-squash-soup/', 'Easy Butternut Squash Soup', 30, 'olive_oil,onion,garlic_cloves,butternut_squash,vegetable_broth,salt,pepper,heavy_cream', 'savory', 'none'),
(11, 'https://www.tasteofhome.com/recipes/beef-roast-dinner/', 'Beef Roast Dinner', 25, 'red_potatoes,baby_carrots,green_pepper,parsnip,mushrooms,red_onion,rump_roast,beef_broth,salt,oregano,pepper,corn_starch,water', 'savory', 'beef'),
(13, 'https://www.tasteofhome.com/recipes/pressure-cooker-coq-au-vin/', 'Pressure-Cooker Coq au Vin', 40, 'bacon,chicken,onion,tomato_paste,garlic,red_wine,carrots,mushrooms,chicken_broth,thyme_sprigs,bay_leaves,kosher_salt,pepper', 'savory', 'chicken'),
(15, 'https://www.jessicagavin.com/baked-salmon/#wprm-recipe-container-40752', 'Baked Salmon', 30, 'salmon,butter,salt,pepper,garlic,lemon,parsley,dill', 'savory', 'fish'),
(17, 'https://chefsavvy.com/30-minute-mongolian-beef/#wprm-recipe-container-27371', '30 Minute Mongolian Beef', 30, 'steak,cornstarch,sesame_oil,vegetable_oil,garlic,ginger,soy_sauce,water,brown_sugar', 'sweet', 'beef'),
(19, 'https://panlasangpinoy.com/sweet-and-sour-tilapia/#recipe', 'Sweet and Sour Tilapia', 40, 'tilapia,peppers,garlic,onion,ketchup,vinegar,sugar,oil,onion,ginger', 'sweet', 'fish'),
(21, 'https://www.allrecipes.com/recipe/279715/spicy-roasted-vegetables/', 'Spicy Roasted Vegetables', 25, 'broccoli,cauliflower,peppers,eggplant,olive_oil,garlic_powder,paprika,onion,salt,pepper', 'spicy', 'none'),
(23, 'https://www.food.com/recipe/spicy-grilled-fish-329515', 'Spicy Grilled Fish', 15, 'fish,lemon,vegetable_oil,soy_sauce,ginger,garlic,onion,paprika,pepper', 'spicy', 'fish'),
(28, 'https://www.myrecipes.com/recipe/spicy-beef-bell-pepper-stir-fry', 'Spicy Beef and Bell Pepper Stir-Fry', 20, 'canola_oil,flank_steak,bell_pepper,soy_sauce,rice_wine_vinegar,fresh_ginger,chili_garlic_sauce,green_onions,sesame_seeds', 'spicy', 'beef'),
(30, 'https://www.dinneratthezoo.com/firecracker-chicken/', 'Firecracker Chicken', 50, 'boneless_skinless_chicken_breasts,salt,pepper,cornstarch,eggs,vegetable_oil,buffalo_hot_sauce,brown_sugar,rice_vinegar,red_pepper_flakes,sliced_green_onions', 'spicy', 'chicken');

-- --------------------------------------------------------

--
-- Table structure for table `tb_users`
--

CREATE TABLE `tb_users` (
  `id` int(11) NOT NULL,
  `user_name` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `favorites` varchar(500) DEFAULT NULL,
  `monday` varchar(200) DEFAULT NULL,
  `tuesday` varchar(200) DEFAULT NULL,
  `wednesday` varchar(200) DEFAULT NULL,
  `thursday` varchar(200) DEFAULT NULL,
  `friday` varchar(200) DEFAULT NULL,
  `saturday` varchar(200) DEFAULT NULL,
  `sunday` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_users`
--

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_advice`
--
ALTER TABLE `tb_advice`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_recipes`
--
ALTER TABLE `tb_recipes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_users`
--
ALTER TABLE `tb_users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_advice`
--
ALTER TABLE `tb_advice`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tb_recipes`
--
ALTER TABLE `tb_recipes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `tb_users`
--
ALTER TABLE `tb_users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
