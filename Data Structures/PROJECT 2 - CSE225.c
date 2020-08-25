/******//////////////////////*/*/////////////////////      PROJECT 3 - CSE225   MUHAMMET HASAN ALBAYRAK 150117053  *////////////////////////////////////


   // #include "muhammethasan_albayrak1.h"
   // #include "muhammethasan_albayrak2.h"
	# include <stdio.h>
    # include <stdlib.h>   
	# include <string.h>   
	# include <math.h>
	# define EMAX 25
	#include <stdio.h>
	#include <stdlib.h>

	#define Error( Str )        FatalError( Str )
	#define FatalError( Str )   fprintf( stderr, "%s\n", Str ), exit( 1 )
	
	typedef double ElementType;
        #define Infinity (6000000000L)

        #ifndef _BinHeap_H
		
		#define MaxTrees (12)   /* Stores 2^9 -1 items */
        #define Capacity (4095)

    //  #define MaxTrees (14)   /* Stores 2^14 -1 items */
    //  #define Capacity (16383)
		
//	#define MaxTrees (30)   /* Stores 2^30 -1 items */
   // #define Capacity (1073741823)

        struct BinNode;
        typedef struct BinNode *BinTree;
        struct Collection;
        typedef struct Collection *BinQueue;
        struct node;
        typedef struct node node;
        typedef node* nodePtr;
        BinQueue Initialize( void );
        void Destroy( BinQueue H );
        BinQueue MakeEmpty( BinQueue H );
        BinQueue Insert(ElementType Item,  BinQueue H, nodePtr nodePtr );
        nodePtr DeleteMin( BinQueue H );
        BinQueue Merge( BinQueue H1, BinQueue H2 );
        ElementType FindMin( BinQueue H );
        int IsEmpty( BinQueue H );
        int IsFull( BinQueue H );
        #endif
/* END */
/* START: fig6_52.txt */
        typedef struct BinNode *Position;
        
        struct node{
        	char strng[25];
        	int exe;
        	int arr;
        	double priority;
        	double waiting;
        	struct node * next;
        	
		};
        typedef struct node node;
        typedef node* nodePtr;
        insertNode(nodePtr * Head, char name[], int e, int t){
        	nodePtr newNode = malloc(sizeof(node));
        	if(newNode == NULL){
        		puts("Not enough memory");
        		return;
			}
			strcpy(newNode->strng, name);
			newNode->exe = e;
			newNode->arr = t;
			newNode->next = NULL;
			newNode->waiting = 0;
			
			if(*Head == NULL){
				*Head = newNode;
			}
			else{
				nodePtr previous = NULL;
	 			nodePtr current = *Head;
		 		while(current->next != NULL){
		 			previous = current;
		 			current = current->next;
			 }
				 current->next = newNode;
				 newNode->next = NULL;
			}
		}
        struct BinNode
        {
        	ElementType Item;
		    nodePtr nodeptr;
            //model_node_type mn;
            Position    LeftChild;
            Position    NextSibling;
        };

        struct Collection
        {
            int CurrentSize;
            BinTree TheTrees[ MaxTrees ];
        };

        BinQueue
        Initialize( void )
        {
            BinQueue H;
            int i;

            H = malloc( sizeof( struct Collection ) );
            if( H == NULL )
                FatalError( "Out of space!!!" );
            H->CurrentSize = 0;
            for( i = 0; i < MaxTrees; i++ )
                H->TheTrees[ i ] = NULL;
            return H;
        }

        static void
        DestroyTree( BinTree T )
        {
            if( T != NULL )
            {
                DestroyTree( T->LeftChild );
                DestroyTree( T->NextSibling );
                free( T );
            }
        }

        void
        Destroy( BinQueue H )
        {
            int i;

            for( i = 0; i < MaxTrees; i++ )
                DestroyTree( H->TheTrees[ i ] );
        }

        BinQueue
        MakeEmpty( BinQueue H )
        {
            int i;

            Destroy( H );
            for( i = 0; i < MaxTrees; i++ )
                H->TheTrees[ i ] = NULL;
            H->CurrentSize = 0;

            return H;
        }

        /* Not optimized for O(1) amortized performance */
        BinQueue
        Insert( ElementType Item, /*model_node_type m,*/ BinQueue H, nodePtr nodePtr )
        {
            BinTree NewNode;
            BinQueue OneItem;
			int i;

            NewNode = malloc( sizeof( struct BinNode ) );
            if( NewNode == NULL )
                FatalError( "Out of space!!!" );
            NewNode->LeftChild = NewNode->NextSibling = NULL;
			NewNode->Item = Item;
			NewNode->nodeptr = nodePtr;
            /*NewNode->mn.p = m.p;
			NewNode->mn.sid.scalar = m.sid.scalar;
			NewNode->mn.aid.d3act = m.aid.d3act;
			NewNode->mn.nexts.scalar = m.nexts.scalar;
			NewNode->mn.reward = m.reward;
			NewNode->mn.last=m.last;
			for (i=0; i < max_act_const; i++) {
			  NewNode->mn.from[i].s=m.from[i].s;
			  NewNode->mn.from[i].a=m.from[i].a;
			}*/  

            OneItem = Initialize( );
            OneItem->CurrentSize = 1;
            OneItem->TheTrees[ 0 ] = NewNode;

            return Merge( H, OneItem );
        }

/* START: fig6_56.txt */
        nodePtr 
        DeleteMin( BinQueue H )
        {
            int i, j;
            int MinTree;   /* The tree with the minimum item */
            BinQueue DeletedQueue;
            Position DeletedTree, OldRoot;
            ElementType MinItem;
            nodePtr min;
			//model_node_type MinItem;

            if( IsEmpty( H ) )
            {
                Error( "Empty binomial queue" );
				MinItem=-Infinity;
				
			//  for (i=0; i < max_act_const; i++) {
			//    MinItem.from[i].s=-1;
			//    MinItem->mn.from[i].a=m.from[i].a;
			//  }
                return NULL;
            }

            MinItem = Infinity;
            for( i = 0; i < MaxTrees; i++ )
            {
                if( H->TheTrees[ i ] &&   H->TheTrees[ i ]->Item < MinItem )
                {
                    /* Update minimum */
                    MinItem = H->TheTrees[ i ]->Item;
					min = H->TheTrees[ i ]->nodeptr;
                    MinTree = i;
                }
            }

            DeletedTree = H->TheTrees[ MinTree ];
            OldRoot = DeletedTree;
            DeletedTree = DeletedTree->LeftChild;
            free( OldRoot );

            DeletedQueue = Initialize( );
            DeletedQueue->CurrentSize = ( 1 << MinTree ) - 1;
            for( j = MinTree - 1; j >= 0; j-- )
            {
                DeletedQueue->TheTrees[ j ] = DeletedTree;
                DeletedTree = DeletedTree->NextSibling;
                DeletedQueue->TheTrees[ j ]->NextSibling = NULL;
            }

            H->TheTrees[ MinTree ] = NULL;
            H->CurrentSize -= DeletedQueue->CurrentSize + 1;

            Merge( H, DeletedQueue );
            return min;
        }
/* END */

        ElementType
        FindMin( BinQueue H )
        {
            int i;
            ElementType MinItem;

            if( IsEmpty( H ) )
            {
                puts( "Empty binomial queue" );
				MinItem=0;
                return MinItem;
            }

            MinItem = Infinity;
			
            for( i = 0; i < MaxTrees; i++ )
            {
                if( H->TheTrees[ i ] &&
                            H->TheTrees[ i ]->Item < MinItem ) {
                    MinItem = H->TheTrees[ i ]->Item;
				}	
            }

            return MinItem;
        }

        int
        IsEmpty( BinQueue H )
        {
            return H->CurrentSize == 0;
        }

        int IsFull( BinQueue H )
        {
            return H->CurrentSize == Capacity;
        }

/* START: fig6_54.txt */
        /* Return the result of merging equal-sized T1 and T2 */
        BinTree
        CombineTrees( BinTree T1, BinTree T2 )
        {
            if( T1->Item > T2->Item )
                return CombineTrees( T2, T1 );
            if(T1->Item == T2->Item && T1->nodeptr->arr > T2->nodeptr->arr){
            	return CombineTrees(T2, T1);
			}
            T2->NextSibling = T1->LeftChild;
            T1->LeftChild = T2;
            return T1;
        }
/* END */

/* START: fig6_55.txt */
        /* Merge two binomial queues */
        /* Not optimized for early termination */
        /* H1 contains merged result */

        BinQueue
        Merge( BinQueue H1, BinQueue H2 )
        {
            BinTree T1, T2, Carry = NULL;
            int i, j;

            if( H1->CurrentSize + H2->CurrentSize > Capacity )
                Error( "Merge would exceed capacity" );

            H1->CurrentSize += H2->CurrentSize;
            for( i = 0, j = 1; j <= H1->CurrentSize; i++, j *= 2 )
            {
                T1 = H1->TheTrees[ i ]; T2 = H2->TheTrees[ i ];

                switch( !!T1 + 2 * !!T2 + 4 * !!Carry )
                {
                    case 0: /* No trees */
                    case 1: /* Only H1 */
                        break;
                    case 2: /* Only H2 */
                        H1->TheTrees[ i ] = T2;
                        H2->TheTrees[ i ] = NULL;
                        break;
                    case 4: /* Only Carry */
                        H1->TheTrees[ i ] = Carry;
                        Carry = NULL;
                        break;
                    case 3: /* H1 and H2 */
                        Carry = CombineTrees( T1, T2 );
                        H1->TheTrees[ i ] = H2->TheTrees[ i ] = NULL;
                        break;
                    case 5: /* H1 and Carry */
                        Carry = CombineTrees( T1, Carry );
                        H1->TheTrees[ i ] = NULL;
                        break;
                    case 6: /* H2 and Carry */
                        Carry = CombineTrees( T2, Carry );
                        H2->TheTrees[ i ] = NULL;
                        break;
                    case 7: /* All three */
                        H1->TheTrees[ i ] = Carry;
                        Carry = CombineTrees( T1, T2 );
                        H2->TheTrees[ i ] = NULL;
                        break;
                }
            }
            return H1;
        }
		
		// by Borahan Tümer
		BinTree printTree(BinTree p, BinTree *r, int i)
		{
		  BinTree t[20]={NULL}, q; int j;
		  for ( j=0; j<i; j++ ) t[j]= r[j];
		  i=0;
		  if (p!=NULL) { 
		    printf("& %2.1lf ",p->Item);
			q=p->NextSibling;
			j=0;
			do {
			  while (q!=NULL) { 
			    printf("%2.1lf ",q->Item); 
			    if (q->LeftChild != NULL) { r[i]=q->LeftChild; i++; }
			    q=q->NextSibling;
			  }
			  q=t[j++];
			} while (q!=NULL);
		  }
		  else return NULL;
		  //for (j=0; j<i; j++) t[j]=NULL;
		  printf("\n");
		  printTree(p->LeftChild, r, i);
		}
		
	void calculate(nodePtr * node, int mode)
	{
		if(mode == 1){
			(*node)->priority = (*node)->exe;
			return;
		}
		(*node)->priority = 1.0 / (exp( pow(-1.0 * ((2.0 * (*node)->exe) / (3.0 * EMAX)), 3.0)));
		(*node)->priority *= (*node)->exe;
		return;
	}	
	delete(nodePtr * head, nodePtr *node){
		nodePtr current = *head;
		while(current != NULL){
			if(strcmp(current->strng, (*node)->strng) == 0){
				current->next = (*node)->next;
				
			}
			current = current->next;
		}
	}
	insert(nodePtr * head, nodePtr* node){
		
		nodePtr current = *head;
		if(current == NULL){
			*head = *node;
			return;
		}
		
		while(current->next != NULL){
			current = current->next;
		}
		current->next = *node;
		(*node)->next = NULL;
	}
		//	/*
	main(){
	BinQueue H1;
	BinTree p, r[20]={NULL};
	ElementType Item;
	char ch;
	int i;
	H1 = Initialize( );
    FILE *input;
	char str[25];
	int in = 0;
	int e = 0;
	int t = 0;
	int maxTime = 0;
	nodePtr head = NULL;
	nodePtr temp = NULL;
	if((input = fopen("input.txt", "r")) == NULL){
 		puts("File could not be opened");
    }
 	else{
 		while(!feof(input)){
 			fscanf(input, "%s", str);
		//	printf("%s ", str);	
			fscanf(input, "%d", &e);
		//	printf("%d ", e);
			fscanf(input, "%d", &t);
			if(t > maxTime)
			maxTime = t;
		//	printf("%d ", t);
 			in++;
 			insertNode(&head, str, e, t);
 	}
 }
 //printf("\n max %d ----", maxTime);
 nodePtr current = head;
 nodePtr headF = NULL;
 temp = head;

//printf("%d \n", in);
 int quantum = 1;
 
 int time = 0;
 nodePtr process = NULL;
 while(current != NULL || !(IsEmpty(H1)) || time < maxTime){
 	if(current != NULL){
 	while(current->arr <= time ){
 		calculate(&current, 1);
 		Insert(current->priority, H1, current);
 		current = current->next;
 		if(current == NULL)
 		break;
		}
	 }
	 if(IsEmpty(H1))	
      time += 1;
	if(!(IsEmpty(H1))){
	
	process = DeleteMin( H1 );
	//printf(" \n %s  -> %lf---", process->strng, process->priority);
	if(process->exe > quantum){
		process->exe -= quantum;
		calculate(&process, 2);
		
	//	printf(" \n %s  -> %lf---", process->strng, process->priority);
		Insert(process->priority, H1, process);
		while(temp != NULL){
			if(!(strcmp(temp->strng, process->strng)) || temp->exe == 0 || temp->arr > time){
				
			}
			else{
				temp->waiting += quantum;
				
			}
			temp = temp->next;
		}
		temp = head;
		time += quantum;
	//	printf(" \ntime -- %d", time);
	}
	else{
	//	delete(&head, &process);
	//	insert(&headF, &process);
		
		
		while(temp != NULL ){
			if(!(strcmp(temp->strng, process->strng)) || temp->exe == 0 || temp->arr > time){
				
			}
			else{
				temp->waiting += process->exe;
				
			}
			temp = temp->next;
		}
		temp = head;
		time += process->exe;
		process->exe = 0;
	//	printf(" \ntime -- %d", time);
	}
}
	
 }
 nodePtr temp2 = head;
  double totalWaiting = 0;
  int check = 0;
 	while(head != NULL){
 		if(check % 2 == 0)
 		printf("  %s-> %.1f                     ", head->strng, head->waiting);
 		else
 		printf("  %s-> %.1f \n", head->strng, head->waiting);
 		totalWaiting += head->waiting;
 		head = head->next;
 		check++;
	 }
 	printf(" \n %.1f  --- %d", totalWaiting , in);
    printf(" \n %.3f", totalWaiting / in);
    printf(" \n quantum = %d", quantum);
    head = temp2;




}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		 		  
		         
/* END */
