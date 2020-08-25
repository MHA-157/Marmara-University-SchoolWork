// MUHAMMET		HASAN		ALBAYRAK		150117053		CSE-1142

# include <stdio.h>
# include <stdlib.h>
# include <string.h>
 
 	int	numberOfsongs;
 
 struct Song{//song struct
 	char songName[25];
 	int duration;
 	struct Song *chrono_next;
 	struct Song *alpha_next;
 	struct Song *duration_next;
 	struct Song *random_next;
 };
    
	 typedef struct Song song;
     typedef song * songPtr;
 
    void insertNode(songPtr *durationHead, songPtr *chronoHead,  songPtr *alphaHead, char name[], int length)
	{
 
 	 songPtr  newMsc = malloc(sizeof(song));//opening space
 	
	 if(newMsc != NULL)
	{
	 	
		newMsc->duration = length;//filling newly opened struct
	 	strcpy(newMsc->songName, name);
	 	newMsc->chrono_next = NULL;
	 	newMsc->alpha_next = NULL;
	 	newMsc->duration_next = NULL;
	 	if(*chronoHead == NULL)//if list is empty
		{
	 		*chronoHead = newMsc;
		}
		
		 else
		{
			
		 	songPtr previous = NULL;
	 	    songPtr current = *chronoHead;
		 	
			while(current->chrono_next != NULL)//finding end of the list
			{
		 	
			 	previous = current;
		 		current = current->chrono_next;
			}
			
			 current->chrono_next = newMsc;
			 newMsc->chrono_next = NULL;
		}
		 
		 if(*durationHead == NULL)//if list empty
		{
		 	*durationHead = newMsc;
		}
		 
		 else
		{
			//
			songPtr previous = NULL;
	 		songPtr current = *durationHead;
	 	
			 while(current != NULL && length > current->duration)//finding rigth place to add song
			{
	 		
		 		previous = current;
	 			current = current->duration_next;
		
			}
		
			if(previous == NULL)//if adding to head
			{
				newMsc->duration_next = *durationHead;
				*durationHead = newMsc;
			}
		
			else
			{
				previous->duration_next = newMsc;
				newMsc->duration_next = current;
			}
		 
		
		}
		 
		if(*alphaHead == NULL)//if list is empty
		{
			*alphaHead = newMsc;
			
		}
		
		else
		{
	      
		songPtr previous = NULL;
	 	songPtr current = *alphaHead;
	 	
	 		while(current != NULL && strcmp(newMsc->songName, current->songName) > 0)//finding rigth place to add song
			{
		 		previous = current;
	 			current = current->alpha_next;
			}
		
			if(previous == NULL)//if adding to head
			{
				newMsc->alpha_next = *alphaHead;
				*alphaHead = newMsc;
			}
		
			else
			{
				previous->alpha_next = newMsc;
				newMsc->alpha_next = current;
			}
		
		}
			numberOfsongs++;
	}
 	
 }
 
    void printList(song *chronoList, song *alphaList, song *durationList, song *randomList)
	{
    	int i = 1;
    	puts("-------------------------------------------------------------------------------------");
    	puts("  The list in chronological order:");
 	    while(chronoList != NULL )//Printing insides by going trough list
		{
		   
 			printf("%s %d:%d ",  chronoList->songName, chronoList->duration / 60, chronoList->duration % 60);
 			chronoList = chronoList->chrono_next;
 			i++;
	    }
	    puts(" ");
	    i = 1;
    	puts("  The list in alphabetical order:");
 	    while(alphaList != NULL )//Printing insides by going trough list
		{
		   
 			printf("%s %d:%d ",  alphaList->songName, alphaList->duration / 60, alphaList->duration % 60);
 			alphaList = alphaList->alpha_next;
 			i++;
	    }
	    puts(" ");
	    i = 1;
    	puts("  The list in duration-time order:");
 	    while(durationList != NULL )//Printing insides by going trough list
		{
		   
 			printf("%s %d:%d ",  durationList->songName, durationList->duration / 60, durationList->duration % 60);
 			durationList = durationList->duration_next;
 			i++;
	    }
	    puts(" ");
	    i = 1;
    	puts("  The list in random order:");
 	    while(randomList != NULL )//Printing insides by going trough list
		{
		   
 			printf("%s %d:%d ",  randomList->songName, randomList->duration / 60, randomList->duration % 60);
 			randomList = randomList->duration_next;
 			i++;
	    }
	    printf("\n");
	    puts("-------------------------------------------------------------------------------------");
 }
 
 	void deleteNode(songPtr *durationHead, songPtr *chronoHead, songPtr *alphaHead, char name[])
	{
		songPtr previous = NULL;//pointers to find place 
		songPtr current = NULL;
		
		 if(*durationHead == NULL)
		{
			puts("List is empty");
			return; 	
		}
		current = *durationHead;
		while(current != NULL && strncmp(name, current->songName, strlen(name)) != 0)//finding the song to delete
		{
			previous = current;
			current = current->duration_next;	
		}
		
		if(previous = NULL)//if going to delete first in list
		{
			*durationHead = current->duration_next;
			return;	
		}
		if(current == NULL)//if cannot find
		{
			puts("Could not find");
			return;
		}
		
		else
		{
			previous->duration_next = current->duration_next;
		}
		
			previous = NULL;
			current = NULL;
		
			current = *chronoHead;
		while(current != NULL && strcmp(name, current->songName) != 0)
		{
			previous = current;
			current = current->duration_next;	
		}
		
		if(previous = NULL)
		{
			*chronoHead = NULL;	
			return;
		}
		
		if(current == NULL)
		{
			puts("Could not find");
			return;
		}
		
		else
		{
			previous->chrono_next = current->chrono_next;
		}
		 	
			 	
		 previous = NULL;
		 current = NULL;
				 
		current = *alphaHead;
		while(current != NULL && strcmp(name, current->songName) != 0)
		{
			previous = current;
			current = current->alpha_next;	
		}
		
		if(previous = NULL)
		{
			*alphaHead = NULL;	
			return;
		}
		
		if(current == NULL)
		{
			puts("Could not find");
			return;
		}
		
		else
		{
			previous->alpha_next = current->alpha_next;
		}
		free(current);
		numberOfsongs--;
		
	}
	
	void printFile(FILE * output, song *chronoList, song *alphaList, song *durationList, song *randomList)
	{
		int i = 1;
    	fputs("-------------------------------------------------------------------------------------", output);
    	fprintf(output, "\n");
    	fputs("The list in chronological order:", output);
 	    while(chronoList != NULL )
		{//Printing insides by going trough list
		   
 			fprintf(output,"%s %d:%d \n",  chronoList->songName, chronoList->duration / 60, chronoList->duration % 60);
 			chronoList = chronoList->chrono_next;
 			i++;
	    }
	    fputs("\n ", output);
	    i = 1;
    	fputs("The list in alphabetical order:", output);
 	    while(alphaList != NULL )
		{//Printing insides by going trough list
		   
 			fprintf(output, "%s %d:%d \n",  alphaList->songName, alphaList->duration / 60, alphaList->duration % 60);
 			alphaList = alphaList->alpha_next;
 			i++;
	    }
	    fputs("\n ", output);
	    i = 1;
    	fputs("The list in duration-time order:", output);
 	    while(durationList != NULL )
		{//Printing insides by going trough list
		   
 			fprintf(output, "%s %d:%d \n",  durationList->songName, durationList->duration / 60, durationList->duration % 60);
 			durationList = durationList->duration_next;
 			i++;
	    }
	    fprintf(output, "\n");
	    i = 1;
    	fputs("The list in random order:", output);
 	    while(randomList != NULL )
		{
		   
 			fprintf(output, "%s %d:%d \n",  randomList->songName, randomList->duration / 60, randomList->duration % 60);
 			randomList = randomList->duration_next;
 			i++;
	    }
	    fputs("\n ", output);
	    fputs("-------------------------------------------------------------------------------------", output);
		fclose(output);
	}
	
 	void shuffle(song * durationHead, songPtr* randomHead)
	{
		srand(time(NULL));
		int i;
		int j;
		//changes places of the first in the list and d random one
		for(i = 0; i < numberOfsongs; i++)
		{
			songPtr current = durationHead;
			songPtr previous = NULL;
			printf("%d \n", i);
			for(j = 0; j < rand() % numberOfsongs + 1 ; j++)//Takes a random number to pick a song
			{
				printf("j = %d \n", j);
				previous = current;
				current = current->duration_next;
				
			}
			if(previous == NULL )
			{
				
			}
			else if(current == NULL) 
			{
				
				
			}
			else
			{
				song * temp = durationHead->duration_next;
				previous->duration_next = durationHead;
				durationHead->duration_next = current->duration_next;
				current->duration_next = temp;
				durationHead = current;
				
			}
		}
		
		*randomHead = durationHead;
	}
 
 int main()
 {
	
 	songPtr durationHead = NULL;
 	songPtr alphaHead = NULL;
 	songPtr chronoHead = NULL;
 	songPtr randomHead = NULL;
 	FILE * songs;
 	int minute = 0;
 	int seconds = 0;
 	char point = 'a';
 	char name[25];
 	int duration;
    int choice;
    char tab;
 
 if((songs = fopen("songs.txt", "r")) == NULL)//opening and checking file
  {
 		puts("File could not be opened");
  }
  
  else
  {
  	
  while(!feof(songs))
  {//reading from file
 	
 	fscanf(songs,"%[^\t]s", name);//name
 	fscanf(songs,"%d", &minute);//duration
 	fscanf(songs,"%c", &point);	
 	fscanf(songs,"%d\n", &seconds);
 	duration = minute * 60 + seconds;
 	insertNode(&durationHead, &chronoHead, &alphaHead, name, duration);//adding them to list
 }
 
 }
    //shuffle(durationHead, &randomHead); 
	printList(chronoHead,  alphaHead, durationHead, randomHead);//printing list
 
    printf("  Enter your choice:\n"
   "      1 to insert a song into the list.\n"
   "      2 to delete a song from the list.\n"
   "      3 to print the songs in the list.\n"
   "      4 to print the songs to an output file.\n"
   "      5 to end.\n");//printing choices
    printf("%s", "? ");//taking choice
    scanf("%d", &choice);//redading choice
     
  while(choice !=5)
 {
 	switch(choice)
	{
		
 	case 1://for adding a song
 		puts("Enter a song name with duration: ");
 		scanf("%[^\t]s", name);//name
 		scanf("%d", &minute);//duration
 		scanf("%c", &point);	
 		scanf("%d", &seconds);
 		duration = minute * 60 + seconds;
 		insertNode(&durationHead, &chronoHead,  &alphaHead, name, duration);//adding them to list
 		//shuffle(durationHead,&randomHead);
	 	break;
    
	case 2://for deleting song
		printf("Enter a song name:");
		scanf("%s", name);
		
		deleteNode(&durationHead, &chronoHead,  &alphaHead, name);	
		//shuffle(durationHead,&randomHead);
		break;
		
	case 3://printing list
		printList(chronoHead,  alphaHead, durationHead, randomHead);	
		break;
	
	case 4://printing list to a file
		puts("Enter a file name:");
		FILE *playlist;//creatin file
		char  file[25];
		scanf("%s", file);//taking file name
		if(( playlist = fopen(file , "w")) != NULL)//opening adn checking file
		{
			printFile(playlist, chronoHead,  alphaHead, durationHead, randomHead);
		}
	}
	
	printf("  Enter your choice:\n"
   "      1 to insert a song into the list.\n"
   "      2 to delete a song from the list.\n"
   "      3 to print the songs in the list.\n"
   "      4 to print the songs to an output file.\n"
   "      5 to end.\n");
    printf("%s", "? ");
    scanf("%d", &choice);
 }
 
 
 fclose(songs);
 
 puts("End of run");
 }
