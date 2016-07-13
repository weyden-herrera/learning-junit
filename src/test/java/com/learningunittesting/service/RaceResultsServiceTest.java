package com.learningunittesting.service;

import org.junit.Test;

import com.learningunittesting.interfaces.Client;
import com.learningunittesting.interfaces.Message;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class RaceResultsServiceTest {
	
	private static final String F1_RACE = "f1Race";
	private static final String HORSE_RACE ="horseRace"; 
	private RaceResultService raceResultService = new RaceResultService();
	private Client clientA = mock(Client.class, "clientA");
	private Client clientB = mock(Client.class, "clientB");
	private Message horseRaceMessage = mock(Message.class, "horseRaceMessage");
	private Message f1Message = mock(Message.class, "f1Message");

	@Test
	public void notSubscribedClientShouldNotReceiveMessage(){
		raceResultService.send(f1Message, F1_RACE);
		
		verify(clientA, never()).receive(f1Message);
		verify(clientB, never()).receive(f1Message);
	}
	
	@Test
	public void subscribedClientShouldReceiveMessage() {
		
		raceResultService.addClient(clientA, F1_RACE);
		raceResultService.send(f1Message, F1_RACE);
		
		verify(clientA).receive(f1Message);
	}
	
	@Test
	public void messageShouldBeSentToAllSubscribedClients(){
		raceResultService.addClient(clientA, F1_RACE);
		raceResultService.addClient(clientB, F1_RACE);
		raceResultService.send(f1Message, F1_RACE);
		
		verify(clientA).receive(f1Message);
		verify(clientB).receive(f1Message);
	}
	
	@Test
	public void shouldSendOnlyOneMessageToMultiSubscriber() {
		raceResultService.addClient(clientA, F1_RACE);
		raceResultService.addClient(clientA, F1_RACE);
		raceResultService.send(f1Message, F1_RACE);
		verify(clientA, times(1)).receive(f1Message);
	}
	
	@Test
	public void unsubscribedClientShouldNotReceiveMessages() {
		raceResultService.addClient(clientA,HORSE_RACE);
		raceResultService.unsubscribeClient(clientA, HORSE_RACE);
		raceResultService.send(horseRaceMessage, HORSE_RACE);
		verify(clientA, never()).receive(horseRaceMessage);
	}
	
	@Test
	public void subscribeToDifferentRaceCategory(){
		raceResultService.addClient(clientA,F1_RACE);
		raceResultService.addClient(clientA,HORSE_RACE);
		raceResultService.send(f1Message, F1_RACE);
		raceResultService.send(horseRaceMessage, HORSE_RACE);
		
		verify(clientA).receive(f1Message);
		verify(clientA).receive(horseRaceMessage);
	}
	
	@Test
	public void receiveMessageOnlyToSubscribeRace(){
		raceResultService.addClient(clientA,F1_RACE);
		raceResultService.send(f1Message, F1_RACE);
		raceResultService.send(horseRaceMessage, HORSE_RACE);
		
		verify(clientA).receive(f1Message);
		verify(clientA, never()).receive(horseRaceMessage);
	}
	
	@Test
	public void everyMessageSentShouldBeLogged(){
		raceResultService.addClient(clientA,F1_RACE);
		raceResultService.addClient(clientA,HORSE_RACE);
		raceResultService.send(f1Message, F1_RACE);
		raceResultService.send(horseRaceMessage, HORSE_RACE);
		
	}
	
	@Test
	public void shouldBeAbleToSendMultipleMessageAtOnce(){
		List<Message> messageList = new ArrayList<>();
		Message message1 = mock(Message.class);
		Message message2 = mock(Message.class);
		messageList.add(message1);
		messageList.add(message2);
		
		raceResultService.addClient(clientA,F1_RACE);
		
		raceResultService.sendMultipleMessage(messageList, F1_RACE);
		
		verify(clientA).receive(message1);
		verify(clientA).receive(message2);
	}

	
}
