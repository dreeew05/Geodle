/*
 * Class Name - CategoryQuestion.java
 * Brief Description - Abstract class that will be the driver
 *                     for polymorphism in CategoryFactory
 * @author G. Bulaong
 */

package core;

public abstract class CategoryQuestion extends CategoryDetail {
	
    public abstract String getQuestion();
    public abstract String getImageLocation();
}
