import React, { useState } from 'react';
import { Button, Card, Group, Text, TextInput, useMantineTheme } from '@mantine/core';
import { At, Mailbox } from 'tabler-icons-react';
import useAuthStore from 'stores/use-auth-store';
import { useMutation } from 'react-query';
import FetchUtils, { ErrorMessage } from 'utils/FetchUtils';
import ResourceURL from 'constants/ResourceURL';
import NotifyUtils from 'utils/NotifyUtils';
import { Empty } from 'types';

// Email validation regex
const EMAIL_REGEX = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

function ClientHomeNewsletter() {
  const theme = useMantineTheme();
  const { user } = useAuthStore();
  const [email, setEmail] = useState('');
  const [emailError, setEmailError] = useState('');

  const subscribeNewsletterApi = useMutation<Empty, ErrorMessage, { email: string }>(
    (request) => FetchUtils.postWithToken(ResourceURL.CLIENT_USER_NEWSLETTER, { email: request.email }),
    {
      onSuccess: () => {
        NotifyUtils.simpleSuccess('Cảm ơn bạn đã đăng ký nhận tin');
        setEmail('');
        setEmailError('');
      },
      onError: () => NotifyUtils.simpleFailed('Đăng ký nhận tin không thành công'),
    }
  );

  const validateEmail = (emailValue: string): boolean => {
    if (!emailValue.trim()) {
      setEmailError('Vui lòng nhập email');
      return false;
    }
    if (!EMAIL_REGEX.test(emailValue)) {
      setEmailError('Email không hợp lệ');
      return false;
    }
    setEmailError('');
    return true;
  };

  const handleEmailChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const value = e.currentTarget.value;
    setEmail(value);
    if (emailError) {
      validateEmail(value);
    }
  };

  const handleSubscribe = () => {
    if (validateEmail(email)) {
      subscribeNewsletterApi.mutate({ email });
    }
  };

  return (
    <Card
      radius="md"
      shadow="sm"
      p="lg"
      sx={{
        backgroundColor: theme.colorScheme === 'dark' ? theme.colors.blue[9] : theme.colors.blue[6],
        color: theme.white,
      }}
    >
      <Group position="apart">
        <Group>
          <Mailbox size={40} strokeWidth={1}/>
          <Text weight={500} sx={{ fontSize: theme.fontSizes.xl }}>
            Đăng ký nhận tin
          </Text>
          <Text sx={{ fontSize: theme.fontSizes.md }}>
            và cập nhật khuyến mãi liên tục...
          </Text>
        </Group>
        <div style={{ position: 'relative' }}>
          <Group spacing="xs" align="center">
            <TextInput
              styles={{
                root: { width: 450 },
                icon: { color: theme.white },
                input: {
                  color: theme.white,
                  border: 'none',
                  backgroundColor: theme.fn.rgba(theme.colors.blue[1], 0.25),

                  '&::placeholder': {
                    color: theme.fn.rgba(theme.colors.gray[0], 0.5),
                  },
                  '&:focus': {
                    borderColor: emailError ? theme.colors.red[3] : theme.colors.blue[2],
                  },
                },
              }}
              placeholder="Địa chỉ email"
              radius="md"
              size="md"
              icon={<At size={16}/>}
              value={email}
              onChange={handleEmailChange}
              disabled={!user}
            />
            {user && (
              <Button
                radius="md"
                size="md"
                variant="white"
                color="blue"
                onClick={handleSubscribe}
                disabled={subscribeNewsletterApi.isLoading || !email.trim()}
              >
                Đăng ký
              </Button>
            )}
          </Group>
          {emailError && (
            <Text size="xs" color={theme.white} sx={{ position: 'absolute', top: '100%', left: 0, marginTop: 4 }}>
              {emailError}
            </Text>
          )}
        </div>
      </Group>
    </Card>
  );
}

export default ClientHomeNewsletter;
