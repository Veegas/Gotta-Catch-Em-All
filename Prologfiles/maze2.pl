pokemon(1,1).
pokemon(1,0).
wall(0,0).
start(0,1).
at(0,1,2,2,[],s0).
end(1,0).
wall(2,2).
wall(X,Y):- X < 0.
wall(X,Y):- Y < 0.
wall(X,Y):- X > 2.
wall(X,Y):- Y > 2.

at(X,Y,H,P,L,result(A, S)):- A=up,
                           \+wall(X,Y),
			                  \+pokemon(X,Y),
                           H1 is H+1,
                           X1 is X+1,
                           at(X1, Y, H1, P, L, S).

at(X,Y,H,P,L,result(A, S)):- A=up,
                           \+wall(X,Y),
                           pokemon(X,Y),
                           delete(L,pokemon(X,Y),L2),
                           P1 is P+1,
                           H1 is H+1,
                           X1 is X+1,
                           at(X1, Y, H1, P1, L2, S).

at(X,Y,H,P,L,result(A, S)):- A=down,
                           \+wall(X,Y),
			                  \+pokemon(X,Y),
                           H1 is H+1,
                           X1 is X-1,
                           at(X1, Y, H1, P, L, S).

at(X,Y,H,P,L,result(A, S)):- A=down,
                           \+wall(X,Y),
                           pokemon(X,Y),
                           delete(L,pokemon(X,Y),L2),
                           P1 is P+1,
                           H1 is H+1,
                           X1 is X-1,
                           at(X1, Y, H1, P1, L2, S).

at(X,Y,H,P,L,result(A, S)):- A=left,
                           \+wall(X,Y),
                           \+pokemon(X,Y),
                           H1 is H+1,
                           Y1 is Y+1,
                           at(X, Y1, H1, P, L, S).

at(X,Y,H,P,L,result(A, S)):- A=left,
                           \+wall(X,Y),
                           pokemon(X,Y),
                           delete(L,pokemon(X,Y),L2),
                           P1 is P+1,
                           H1 is H+1,
                           Y1 is Y+1,
                           at(X, Y1, H1, P1, L2, S).

at(X,Y,H,P,L,result(A, S)):- A=right,
                           \+wall(X,Y),
			                  \+pokemon(X,Y),
                           H1 is H+1,
                           Y1 is Y-1,
                           at(X, Y1, H1, P, L, S).

at(X,Y,H,P,L,result(A, S)):- A=right,
                           \+wall(X,Y),
                           pokemon(X,Y),
                           delete(L,pokemon(X,Y),L2),
                           P1 is P+1,
                           H1 is H+1,
                           Y1 is Y-1,
                           at(X, Y1, H1, P1, L2, S).


find_solution(X,Y,L,S):-find_solution(X,Y,L,1,S).

find_solution(X,Y,L,Limit,S):- call_with_depth_limit(at(X,Y,0,0,L,S),Limit,A),
				                    ((A = depth_limit_exceeded,
                                 Limit1 is Limit+1,
				                    find_solution(X,Y,L,Limit1,S));
                                (A \= depth_limit_exceeded, !)).

%query used: find_solution(1,0,[pokemon(1,1),pokemon(1,0)],S).









