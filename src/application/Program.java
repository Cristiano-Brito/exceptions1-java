package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entites.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Scanner input = new Scanner(System.in);

		System.out.print("Room number: ");
		int roomNumber = input.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(input.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(input.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println(reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(input.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(input.next());
			
			
			if(reservation.updateDates(checkIn, checkOut) == null) {
				reservation.updateDates(checkIn, checkOut);
				System.out.println(reservation);
			}
			else {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
		}
				
		input.close();
	}

}
