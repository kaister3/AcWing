#include<bits/stdc++.h>

using namespace std;

const int N = 1e5 + 10;
int n;

int a[N], b[N]; // a original array b operation array

void quickSort(int l, int r) {
    if (l >= r) return;
    int mid = l + r >> 1;

    quickSort(l, mid);
    quickSort(mid + 1, r);

    int k = l, i = l, j = mid + 1;
    while (i <= mid && j <= r) {
        if (a[i] <= a[j]) {
            b[k++] = a[i++];
        } else {
            b[k++] = a[j++];
        }
    }

    while (i <= mid) {
        b[k++] = a[i++];
    }

    while (j <= r) {
        b[k++] = a[j++];
    }

    for (k = l; k <= r; k++) {
        a[k] = b[k];
    }
}

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        scanf("%d", &a[i]);
    }

    quickSort(0, n - 1);

    for (int i = 0; i < n; i++) {
        cout << a[i] << " ";
    }
}