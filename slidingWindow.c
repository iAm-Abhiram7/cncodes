#include<stdio.h>in
int main()
{
    int window_size, num_frames, frames[30], i, j, sent = 0;

    printf("Enter window size: ");
    scanf("%d", &window_size);
    printf("Enter number of frames to transmit: ");
    scanf("%d", &num_frames);

    printf("Enter %d frames: \n", num_frames);
    for (i = 0; i < num_frames; i++)
    {
        scanf("%d", &frames[i]);
    }

    printf("\nWith sliding window protocol, the frames will be sent as follows (assuming no corruption):\n");

    while (sent < num_frames)
    {
        for (i = 0; i < window_size && (sent + i) < num_frames; i++)
        {
            printf("%d ", frames[sent + i]);
        }

        printf("\nAcknowledgement of above frames sent is received by sender\n");

        // Slide the window
        sent += i;
    }

    return 0;
}