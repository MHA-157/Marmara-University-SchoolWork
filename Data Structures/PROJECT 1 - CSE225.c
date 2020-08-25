# include <stdio.h>
# include <stdlib.h>
# include <string.h>
# include <math.h>
# include <locale.h>

	struct word{
		char wordLength[25];
		struct word *nextWord;
		struct word *firstNext;
		struct word *secondNext;
		struct word *thirdNext;
		char file[25];
		int count;
		int fcount;
		char category[25];
	};
	
	struct file{
		struct file *nextFile;
		char fileName[25];
		
	};
	
	typedef struct word word;
	typedef word * wordPtr;
	
	typedef struct file file;
	typedef file * filePtr;
	
	
	
	void	addFile(char name[],filePtr *fileHead){
		filePtr newFile = malloc(sizeof(file));
		
		if(newFile != NULL){
			strcpy(newFile->fileName, name);
			newFile->nextFile = NULL;
		}
		
		if(*fileHead == NULL){
			*fileHead = newFile;
		}
		else{
			filePtr previous = NULL;
			filePtr current = *fileHead;
			while(current->nextFile != NULL){
				
				previous = current;
				current = current->nextFile;	
			}
			current->nextFile = newFile;
			newFile->nextFile = NULL;
		}
		
	}
	
	
    void	readFile(filePtr *fileHead, wordPtr *wordHead){
    	char Str[25];
    	setlocale(LC_ALL, "");
		FILE *document;
		char c;
		char k;
		char str[2];
		str[1] = '\0';
		int i, j;
		wordPtr newWord = malloc(sizeof(word));
		char wrd[25] = "";
		char buff[25] = "\0";
		filePtr fileIndex = *fileHead;
		while(fileIndex != NULL){
			document = fopen(fileIndex->fileName,"r");
			while(!feof(document)){
			
				fscanf(document, "%c", &c);
				
				
				if(c == ' ' || c == '\n' )
				{
					/*for(i = 0; wrd[i] != '\0'; ++i)
					{
    				    while (!( (wrd[i] >= 'a' && wrd[i] <= 'z') ||  wrd[i] == '\0') )
     				   {
        				    for(j = i; wrd[j] != '\0'; ++j)
        				    {
            				    wrd[j] = wrd[j+1];
          					  }
         				   wrd[j] = '\0';
        				}
    				}*/
				if(!(k == ' ' || k == '\n')){
				
				addWord(wrd, wordHead, fileIndex->fileName);
				strcpy(wrd, buff);
				}
			}
			else
			{
				k = c;
				str[0] = c;
				strcat(wrd, str);
			}
				
					}
					for(i = 0; i < 25; i++){
						if(wrd[i] == '\0')
						wrd[i - 1] = '\0';
					}
				addWord(wrd, wordHead, fileIndex->fileName);
				strcpy(wrd, buff);
				filePtr temp = fileIndex->nextFile;
				free(fileIndex);
				fileIndex = temp;
			}
		
		}
		
	addWord(char wrd[25], wordPtr *wordHead, char file[25]){
		setlocale(LC_ALL, "");
		char buff[25] = "\0";
		int i = 1;
		wordPtr newWord = malloc(sizeof(word));
		
		
		if(newWord != NULL){
			strcpy(newWord->wordLength, wrd);
			newWord->count = 1;
			newWord->fcount = 1;
			newWord->nextWord = NULL;
			strcpy(wrd, buff);
			strcpy(newWord->file, file);
			
		}
			if(*wordHead == NULL){
				*wordHead = newWord;
				
				}
			else{
				wordPtr previous = NULL;
				wordPtr current = *wordHead;
					
				while(current->nextWord != NULL){
					if(!(strcmp(current->wordLength, newWord->wordLength))){
						current->count++;
						
						if(!(strcmp(current->file, newWord->file))){
							current->fcount = current->fcount;
						}
						else{
							strcpy(current->file, newWord->file);
							current->fcount++;
						}
						free(newWord);
						return;
					}
					else{
						previous = current;
						current = current->nextWord;
						}
							
				}
				current->nextWord = newWord;
				newWord->nextWord = NULL;
				
						
			}	
		}
	
		
	
	
	int main(){
		setlocale(LC_ALL, "");
		wordPtr wordHead = NULL;
		filePtr fileHead = NULL;
		char check[25] ="-1";
		int fileCounter = 0;
		char buffer[25] = "";
		int index = 1;
		FILE *text;
		char buff[25] = "";
		char folder[25];
		
		puts("econ");
		puts("-----------------------------------------------------------------");
		strcpy(check, "econ");
		if(strcmp(check, "0")){
			index = 1;
			strcat(check, "/");
			strcpy(folder, check);
			strcpy(check, folder);
			sprintf(buffer, "%d", index);
			strcat(check, buffer);
			strcat(check, ".txt");
			text = fopen(check, "r");
			while(text){
				addFile(check, &fileHead);
				fileCounter++;
				index++;
				strcpy(buffer, buff);
				strcpy(check, folder);
				sprintf(buffer, "%d", index);
				strcat(check, buffer);
				strcat(check, ".txt");
				text = fopen(check, "r");	
			}
		}
		wordPtr econHead = NULL;
		
		int i;
		readFile(&fileHead, &econHead);
		int max[10] = {0};
		wordPtr wrdMax[10];
		wordPtr head = econHead;
		
		for(i = 0; i < 10; i++){
			while(head != NULL){
				if(head->count > max[i]){
					if(head->wordLength[0] != '\0'){
						max[i] = head->count;
						wrdMax[i] = head;
						
					}
				}
				head = head->nextWord;	
			}
			wrdMax[i]->count = 0;
			head = econHead;
		}
		
				
		
		puts("-----------------------------------------------------------------\n"
		"b)");
		int j;
		
		for(i = 0; i < 10; i++){
			printf("%s;%d \n", wrdMax[i]->wordLength, max[i]);
		}
		
	puts("---------------------------------------------------------------------\n"
		"c)");
		for(i = 0; i < 10; i++){
			printf("%s;%.1f \n", wrdMax[i]->wordLength, max[i] * (log(fileCounter) / wrdMax[i]->fcount));
		}
	    fileHead = NULL;
	    fileCounter = 0;
	    puts("-----------------------------------------------------------------"
	"	");	
		puts("health");
		strcpy(check, "health");
		if(strcmp(check, "0")){
			index = 1;
			strcat(check, "/");
			strcpy(folder, check);
			strcpy(check, folder);
			sprintf(buffer, "%d", index);
			strcat(check, buffer);
			strcat(check, ".txt");
			text = fopen(check, "r");
			while(text){
				addFile(check, &fileHead);
				fileCounter++;
				index++;
				strcpy(buffer, buff);
				strcpy(check, folder);
				sprintf(buffer, "%d", index);
				strcat(check, buffer);
				strcat(check, ".txt");
				text = fopen(check, "r");	
			}
		}
		
		wordPtr healthHead = NULL;
			 
		
		readFile(&fileHead, &healthHead);
		int hmax[10] = {0};
		wordPtr hwrdMax[10];
		head = healthHead;
		
		for(i = 0; i < 10; i++){
			while(head != NULL){
				if(head->count > hmax[i]){
					if(head->wordLength[0] != '\0'){
						hmax[i] = head->count;
						hwrdMax[i] = head;
						
					}
				}
				
				head = head->nextWord;	
			}
			hwrdMax[i]->count = 0;
			head = healthHead;
		}
		
				
		
			
		puts("-----------------------------------------------------------------\n"
		"b)");	
		
		for(i = 0; i < 10; i++){
			printf("%s;%d \n", hwrdMax[i]->wordLength, hmax[i]);
		}
		
	puts("---------------------------------------------------------------------\n"
		"c)");	
		
		for(i = 0; i < 10; i++){
			printf("%s;%.1f \n", hwrdMax[i]->wordLength, hmax[i] * (log(fileCounter) / hwrdMax[i]->fcount));
		}
	
		fileHead = NULL;	
		fileCounter = 0;
		puts("---------------------------------------------------------------------"
	"	")	;
		puts("magazin");	
		puts("---------------------------------------------------------------------"
		"");	
		strcpy(check, "magazin");
		if(strcmp(check, "0")){
			index = 1;
			strcat(check, "/");
			strcpy(folder, check);
			strcpy(check, folder);
			sprintf(buffer, "%d", index);
			strcat(check, buffer);
			strcat(check, ".txt");
			text = fopen(check, "r");
			while(text){
				addFile(check, &fileHead);
				fileCounter++;
				index++;
				strcpy(buffer, buff);
				strcpy(check, folder);
				sprintf(buffer, "%d", index);
				strcat(check, buffer);
				strcat(check, ".txt");
				text = fopen(check, "r");	
			}
		}
		
		wordPtr magazinHead = NULL;
		
		
		readFile(&fileHead, &magazinHead);
		int Mmax[10] = {0};
		wordPtr MwrdMax[10];
		head = magazinHead;
		
		for(i = 0; i < 10; i++){
			while(head != NULL){
				if(head->count > Mmax[i]){
					if(head->wordLength[0] != '\0'){
						Mmax[i] = head->count;
						MwrdMax[i] = head;
						
					}
				}
				head = head->nextWord;	
			}
			MwrdMax[i]->count = 0;
			head = magazinHead;
		}
		
				
		puts("---------------------------------------------------------------------\n"
		"b)");
			
		for(i = 0; i < 10; i++){
			printf("%s;%d \n", MwrdMax[i]->wordLength, Mmax[i]);
		}
		
        puts("---------------------------------------------------------------------\n"
		"c)");	
		
		for(i = 0; i < 10; i++){
			printf("%s;%.1f \n", MwrdMax[i]->wordLength, Mmax[i] * (log(fileCounter) / MwrdMax[i]->fcount));
		}
	}
