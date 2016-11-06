%consult(KB).
end(0,0).
wall(1,0).
wall(1,1).
wall(1,3).
wall(1,4).
start(2,2).
at(2,2,11,7,s0).
wall(3,1).
wall(3,3).
wall(4,1).
wall(4,3).
pokemon(0,4).
pokemon(2,0).
pokemon(2,3).
pokemon(3,0).
pokemon(3,4).
pokemon(4,0).
pokemon(4,4).

%
% at(X,Y,H,P,result(A, S)):-
% 			  			(pokemon(X,Y,S), A=collect(P1,S),P is P1-1, X1 = X, Y1 = Y, H1 = H);
% 		          (\+wall(X,Y),A=up(X1,Y,H1,S), X is X1-1, H is H1-1,X1>0, X1 =< 4, Y1 = Y, P1 = P);
%               (\+wall(X,Y),A=down(X1,Y,H1,S), X is X1+1, H is H1-1, X1<4, X1 >= 0 , Y1 = Y, P1 = P);
% 		          (\+wall(X,Y),A=right(X,Y1,H1,S), Y is Y1+1, H is H1-1,Y1<4, Y1 >= 0, X1 = X, P1 = P);
%               (\+wall(X,Y),A=left(X,Y1,H1,S), Y is Y1-1, H is H1-1,Y1>0, Y1 =< 4, X1 = X, P1 = P));
% 			  			(\+pokemon(X,Y,S),A=collect(P,S));
%               (wall(X1,Y),A=up(X,Y,H,S), X is X1-1);
%               (wall(X1,Y),A=down(X,Y,H,S), X is X1+1);
%               (wall(X,Y1),A=right(X,Y,H,S), Y is Y1+1);
%               (wall(X,Y1),A=left(X,Y,H,S), Y is Y1-1).

possible(up, S):-
	at(X,Y,H,P,S),
	X1 is X + 1,
	X > 0,
	X < 4,
	\+wall(X1, Y).

possible(down, S):-
	at(X,Y,H,P,S),
	X1 is X - 1,
	X > 0,
	X < 4,
	\+wall(X1, Y).

possible(right, S):-
	at(X,Y,H,P,S),
	Y1 is Y + 1,
	Y > 0,
	Y < 4,
	\+wall(X, Y1).

possible(left, S):-
	at(X,Y,H,P,S),
	Y1 is Y - 1,
	Y > 0,
	Y < 4,
	\+wall(X, Y1).

possible(collect, S):-
	at(X,Y, H, P, S), pokemon(X,Y).


at(X,Y, H,P, result(collect, S)):-
			(at(X,Y, H, P1, S), pokemon(X,Y), P is P1 - 1);
			(at(X,Y, H, P, S), \+pokemon(X,Y)).

at(X,Y,H, P,result(up, S)):-
		at(Xup, Y, H1, P, S), (\+wall(X,Y), X is Xup - 1, H is H1 - 1);
		at(X, Y, H, P, S), (wall(X1,Y), X1 is X + 1).

at(X,Y,H, P,result(down, S)):-
		at(Xdown, Y, H1, P, S), (\+wall(X,Y), X is Xdown + 1, H is H1 - 1);
		at(X, Y, H, P, S), (wall(X1,Y), X1 is X - 1).

at(X,Y,H, P,result(right, S)):-
		at(X, Yright, H1, P, S), (\+wall(X,Y), Y is Yright + 1, H is H1 - 1);
		at(X, Y, H, P, S), (wall(X,Y1), Y1 is Y - 1).

at(X,Y,H, P,result(left, S)):-
		at(X, Yleft, H1, P, S), (\+wall(X,Y), Y is Yleft - 1, H is H1 - 1);
		at(X, Y, H, P, S),	(wall(X,Y1), Y1 is Y + 1).

legalState(s0).
legalState(result(A, S)):-
		legalState(S),
		possible(A, S).

	query(X,Y,H,P,S):-
		legalState(S),
		at(X,Y,H,P,S).
