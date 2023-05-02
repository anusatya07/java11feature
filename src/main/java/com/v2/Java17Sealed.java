package com.v2;

 class Java17Sealed {

}
/**Class Level Rule for sealed classes*/
 //purpose of sealed classes final having restriction so we can use sealed class we can give permission for extends 
sealed class Person permits Employee,Student {
	
}
 //if root is sealed then subclass should be final, sealed , non-sealed
	/*
	 * if i given permite then this class we should be extends that classes
	 * otherwise we will get compile time Permitted class Student does not declare
	 * pkg.Person as direct super class
	 */
non-sealed class Employee extends Person{}

/*
 * if subclass craeted as sealed then we will get such Compiletime error  Sealed class or interface lacks the permits
 * clause and no class or interface from the same compilation unit declares
 * Student as its direct superclass or superinterface
 */
final class Student extends Person{}
// here Person not given permission(permits) to bike we can't extends
class Bike{}

/**interface Level Rule for sealed classes*/
// same rule for interface like class
//But interface we can use only sealed or non-sealed bcz we can't create interface as final

sealed interface Person1 permits Employee1{}

non-sealed interface Employee1 extends Person1{}




