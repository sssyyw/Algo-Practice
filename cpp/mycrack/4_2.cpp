stack<int> q;
bool route(int src, int dst){
    q.push(src);
    visited[src] = true;
    while(!q.empty()){
        int t = q.front();
        q.pop();
        if (t == dst) return true;
        for (int i = 0; i < n; ++i)
            if (g[t][i] && !visited[i]){
                q.push(i);
                visited[i] = true;
            }
    }
    return false;
}
