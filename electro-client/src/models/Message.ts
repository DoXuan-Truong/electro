import BaseResponse from 'models/BaseResponse';

export interface MessageResponse extends BaseResponse {
  content: string;
  image?: string;
  status: number;
  user: UserResponse;
}

interface UserResponse {
  id: number;
  username: string;
  fullname: string;
  email: string;
}

export interface MessageRequest {
  content: string;
  image?: string;
  status: number;
  userId: number;
  roomId: number;
}
