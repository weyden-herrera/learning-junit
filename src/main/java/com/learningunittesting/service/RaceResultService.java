package com.learningunittesting.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.learningunittesting.interfaces.Client;
import com.learningunittesting.interfaces.Message;

public class RaceResultService {
	
	private static final String F1_RACE = "f1Race";
	private static final String HORSE_RACE ="horseRace"; 
	private Set<Client> f1ClientList = new HashSet<Client>();
	private Set<Client> horseRaceClientList = new HashSet<Client>();

	public void addClient(Client client, String raceName) {
		
		if(F1_RACE.equals(raceName)){
			this.f1ClientList.add(client);
		}else if(HORSE_RACE.equals(raceName)){
			this.horseRaceClientList.add(client);
		}
		
		
		
	}

	public void send(Message message, String raceName) {
		
		if(F1_RACE.equals(raceName)){
			for(Client client : f1ClientList){
				client.receive(message);
			}
		}else if(HORSE_RACE.equals(raceName)){
			for(Client client : horseRaceClientList){
				client.receive(message);
			}
		}
		
		
		
	}

	public void unsubscribeClient(Client client, String raceName) {
		if(F1_RACE.equals(raceName)){
			this.f1ClientList.remove(client);
		}else if(HORSE_RACE.equals(raceName)){
			this.horseRaceClientList.remove(client);
		}
	}

	public void sendMultipleMessage(List<Message> messageList, String raceName) {
		for(Message message : messageList){
			send(message, raceName);
		}
		
	}

}
