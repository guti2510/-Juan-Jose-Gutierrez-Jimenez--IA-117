#include<stdio.h>


void next_move(int posr, int posc, char board[5][5]) {
    
        
        if (board[posr][posc] == 'd'){
            printf("CLEAN \n");
            board[posr][posc] = 'b';
        }
       
        else if( posr == 0 && posc != 4 ){
            printf("RIGHT \n");
        }
        else if( posr == 1  && posc != 0 ){
            printf("LEFT \n");
        }
        else if( posr == 2 && posc != 4 ){
            printf("RIGHT \n");
        }
        else if( posr == 3 && posc != 0 ){
            printf("LEFT \n");
        }
        else if( posr == 4 && posc != 4  ){
            printf("RIGHT \n");
        }
        else if ( posc == 0){
            printf("DOWN \n");
        }
        else if ( posc == 4){
            printf("DOWN \n");

        }
    
}
int main(void) {
    int pos[2], i;
    char board[5][5], line[6];
    scanf("%d", &pos[0]);
    scanf("%d", &pos[1]);
    for(i=0; i<5; i++) {
        scanf("%s[^\\n]%*c", line);
        strncpy(board[i], line, 5);
    }
    
    next_move(pos[0], pos[1], board);
    return 0;
}